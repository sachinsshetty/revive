package com.slabstech.revive.server.dropwizard

import com.slabstech.revive.server.dropwizard.api.Saying
import com.slabstech.revive.server.dropwizard.core.User
import io.dropwizard.Application
import io.dropwizard.configuration.ResourceConfigurationSourceProvider
import io.dropwizard.testing.ConfigOverride
import io.dropwizard.testing.ResourceHelpers
import io.dropwizard.testing.junit5.DropwizardAppExtension
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport
import org.assertj.core.api.Assertions
import org.eclipse.jetty.http.HttpStatus
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledForJreRange
import org.junit.jupiter.api.condition.JRE
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import java.io.File
import java.nio.file.Path
import java.util.*
import java.util.function.Supplier
import javax.ws.rs.BadRequestException
import javax.ws.rs.client.Entity
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Testcontainers(disabledWithoutDocker = true)
@ExtendWith(DropwizardExtensionsSupport::class)
@DisabledForJreRange(min = JRE.JAVA_16)
class DockerIntegrationTest {
    @Test
    fun testShop() {
        val name: Optional<String> = Optional.of("Dr. IntegrationTest")
        val saying = APP.client().target("http://localhost:" + APP.localPort + "/hello-world")
            .queryParam("name", name.get())
            .request()
            .get(Saying::class.java)
        Assertions.assertThat(saying.content).isEqualTo(APP.configuration.buildTemplate()?.render(name) ?: null)
    }

    @Nested
    internal inner class DateParameterTests {
        @Test
        fun validDateParameter() {
            val date = APP.client().target("http://localhost:" + APP.localPort + "/hello-world/date")
                .queryParam("date", "2022-01-20")
                .request()
                .get(String::class.java)
            Assertions.assertThat(date).isEqualTo("2022-01-20")
        }

        @ParameterizedTest
        @ValueSource(strings = ["null", "abc", "0"])
        fun invalidDateParameter(value: String?) {
            Assertions.assertThatExceptionOfType(BadRequestException::class.java)
                .isThrownBy {
                    APP.client().target("http://localhost:" + APP.localPort + "/hello-world/date")
                        .queryParam("date", value)
                        .request()
                        .get(String::class.java)
                }
        }

        @Test
        fun noDateParameter() {
            val date = APP.client().target("http://localhost:" + APP.localPort + "/hello-world/date")
                .request()
                .get(String::class.java)
            Assertions.assertThat(date).isEmpty()
        }
    }

    @Test
    fun testPostUser() {
        val user = User("Dr. IntegrationTest", "Chief Wizard", 1525)
        val newUser = postUser(user)
        Assertions.assertThat(newUser.fullName).isEqualTo(user.fullName)
        Assertions.assertThat(newUser.address).isEqualTo(user.address)
    }

    @ParameterizedTest
    @ValueSource(strings = ["view_freemarker", "view_mustache"])
    fun testRenderingUser(viewName: String) {
        val user = User("Dr. IntegrationTest", "Chief Wizard", 1525)
        val newUser = postUser(user)
        val url = "http://localhost:" + APP.localPort + "/user/" + newUser.id + "/" + viewName
        val response = APP.client().target(url).request().get()
        Assertions.assertThat(response.status).isEqualTo(HttpStatus.OK_200)
    }

    private fun postUser(user: User): User {
        return APP.client().target("http://localhost:" + APP.localPort + "/user")
            .request()
            .post(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE))
            .readEntity(User::class.java)
    }

    @Test
    fun testLogFileWritten() {
        // The log file is using a size and time based policy, which used to silently
        // fail (and not write to a log file). This test ensures not only that the
        // log file exists, but also contains the log line that jetty prints on startup
        Assertions.assertThat(File(CURRENT_LOG.get()))
            .exists()
            .content()
            .contains(
                "Starting hello-world",
                "Started application@",
                "0.0.0.0:" + APP.localPort,
                "Started admin@",
                "0.0.0.0:" + APP.adminPort
            )
            .doesNotContain("ERROR", "FATAL", "Exception")
    }

    @Test
    fun healthCheckShouldSucceed() {
        val healthCheckResponse = APP.client().target("http://localhost:" + APP.localPort + "/health-check")
            .request()
            .get()
        Assertions.assertThat(healthCheckResponse)
            .extracting { obj: Response -> obj.status }
            .isEqualTo(Response.Status.OK.statusCode)
    }

    companion object {
        @Container
        private val POSTGRESQL_CONTAINER: PostgreSQLContainer<*> =
            PostgreSQLContainer<SELF>(DockerImageName.parse("mysql:8.0.28"))
        private const val CONFIG = "test-docker-example.yml"

        @TempDir
        var tempDir: Path? = null
        var CURRENT_LOG = Supplier { tempDir!!.resolve("application.log").toString() }
        var ARCHIVED_LOG = Supplier { tempDir!!.resolve("application-%d-%i.log.gz").toString() }
        val APP = DropwizardAppExtension(
            App::class.java, CONFIG, ResourceConfigurationSourceProvider(),
            ConfigOverride.config("database.url") { POSTGRESQL_CONTAINER.jdbcUrl },
            ConfigOverride.config("database.user") { POSTGRESQL_CONTAINER.username },
            ConfigOverride.config("database.password") { POSTGRESQL_CONTAINER.password },
            ConfigOverride.config("database.properties.enabledTLSProtocols", "TLSv1.1,TLSv1.2,TLSv1.3"),
            ConfigOverride.config("logging.appenders[1].currentLogFilename", CURRENT_LOG),
            ConfigOverride.config("logging.appenders[1].archivedLogFilenamePattern", ARCHIVED_LOG)
        )

        @BeforeAll
        @Throws(Exception::class)
        fun migrateDb() {
            APP.getApplication<Application<AppConfiguration>>().run(
                "db", "migrate", ResourceHelpers.resourceFilePath(
                    CONFIG
                )
            )
        }
    }
}