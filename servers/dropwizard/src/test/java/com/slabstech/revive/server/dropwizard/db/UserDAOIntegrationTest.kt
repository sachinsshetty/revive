package com.slabstech.revive.server.dropwizard.db

import com.slabstech.revive.server.dropwizard.core.User
import io.dropwizard.testing.junit5.DAOTestExtension
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport
import org.assertj.core.api.Assertions
import org.hibernate.cfg.AvailableSettings
import org.hibernate.cfg.Configuration
import org.hibernate.dialect.MySQL57Dialect
import org.hibernate.exception.ConstraintViolationException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledForJreRange
import org.junit.jupiter.api.condition.JRE
import org.junit.jupiter.api.extension.ExtendWith
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import java.util.*
import java.util.concurrent.Callable

//import com.mysql.cj.conf.PropertyKey;
@Testcontainers(disabledWithoutDocker = true)
@ExtendWith(DropwizardExtensionsSupport::class)
@DisabledForJreRange(min = JRE.JAVA_16)
internal class UserDAOIntegrationTest {
    var daoTestRule = DAOTestExtension.newBuilder()
        .customizeConfiguration { c: Configuration ->
            c.setProperty(
                AvailableSettings.DIALECT,
                MySQL57Dialect::class.java.name
            )
        }
        .setDriver(PostgreSQLContainer.driverClassName)
        .setUrl(PostgreSQLContainer.jdbcUrl)
        .setUsername(PostgreSQLContainer.username)
        .setPassword(PostgreSQLContainer.password) //  .setProperty(PropertyKey.tlsVersions.getKeyName(), "TLSv1.1,TLSv1.2,TLSv1.3")
        .addEntityClass(User::class.java)
        .build()
    private var userDAO: UserDAO? = null
    @BeforeEach
    fun setUp() {
        userDAO = UserDAO(daoTestRule.sessionFactory)
    }

    @Test
    fun createUser() {
        val jeff = daoTestRule.inTransaction<User?> { userDAO!!.create(User("Jeff", "The plumber", 1995)) }
        Assertions.assertThat(jeff!!.id).isPositive
        Assertions.assertThat(jeff.fullName).isEqualTo("Jeff")
        Assertions.assertThat(jeff.address).isEqualTo("The plumber")
        Assertions.assertThat(jeff.yearBorn).isEqualTo(1995)
        Assertions.assertThat(
            userDAO!!.findById(
                jeff.id
            )
        ).isEqualTo(Optional.of(jeff))
    }

    @Test
    fun findAll() {
        daoTestRule.inTransaction {
            userDAO!!.create(User("Jeff", "The plumber", 1975))
            userDAO!!.create(User("Jim", "The cook", 1985))
            userDAO!!.create(User("Randy", "The watchman", 1995))
        }
        val users = userDAO!!.findAll()
        Assertions.assertThat(users).extracting("fullName").containsOnly("Jeff", "Jim", "Randy")
        Assertions.assertThat(users).extracting("jobTitle").containsOnly("The plumber", "The cook", "The watchman")
        Assertions.assertThat(users).extracting("yearBorn").containsOnly(1975, 1985, 1995)
    }

    @Test
    fun handlesNullFullName() {
        Assertions.assertThatExceptionOfType(
            ConstraintViolationException::class.java
        ).isThrownBy {
            daoTestRule.inTransaction(
                Callable { userDAO!!.create(User(null, "The null", 0)) })
        }
    }

    companion object {
        @Container
        private val PostgreSQLContainer: PostgreSQLContainer<*> =
            PostgreSQLContainer<SELF>(DockerImageName.parse("mysql:8.0.24"))
    }
}