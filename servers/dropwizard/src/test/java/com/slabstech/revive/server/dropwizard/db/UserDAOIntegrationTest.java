package com.slabstech.revive.server.dropwizard.db;

import com.slabstech.revive.server.dropwizard.core.User;
//import com.mysql.cj.conf.PropertyKey;
import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import javax.annotation.PropertyKey;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@Testcontainers(disabledWithoutDocker = true)
@ExtendWith(DropwizardExtensionsSupport.class)
@DisabledForJreRange(min = JRE.JAVA_16)
class UserDAOIntegrationTest {
    @Container
    private static final PostgreSQLContainer<?> PostgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse("mysql:8.0.24"));

    public DAOTestExtension daoTestRule = DAOTestExtension.newBuilder()
            .customizeConfiguration(c -> c.setProperty(AvailableSettings.DIALECT, MySQL57Dialect.class.getName()))
            .setDriver(PostgreSQLContainer.getDriverClassName())
            .setUrl(PostgreSQLContainer.getJdbcUrl())
            .setUsername(PostgreSQLContainer.getUsername())
            .setPassword(PostgreSQLContainer.getPassword())
          //  .setProperty(PropertyKey.tlsVersions.getKeyName(), "TLSv1.1,TLSv1.2,TLSv1.3")
            .addEntityClass(User.class)
            .build();

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO(daoTestRule.getSessionFactory());
    }

    @Test
    void createUser() {
        final User jeff = daoTestRule.inTransaction(() -> userDAO.create(new User("Jeff", "The plumber", 1995)));
        assertThat(jeff.getId()).isPositive();
        assertThat(jeff.getFullName()).isEqualTo("Jeff");
        assertThat(jeff.getAddress()).isEqualTo("The plumber");
        assertThat(jeff.getYearBorn()).isEqualTo(1995);
        assertThat(userDAO.findById(jeff.getId())).isEqualTo(Optional.of(jeff));
    }

    @Test
    void findAll() {
        daoTestRule.inTransaction(() -> {
            userDAO.create(new User("Jeff", "The plumber", 1975));
            userDAO.create(new User("Jim", "The cook", 1985));
            userDAO.create(new User("Randy", "The watchman", 1995));
        });

        final List<User> users = userDAO.findAll();
        assertThat(users).extracting("fullName").containsOnly("Jeff", "Jim", "Randy");
        assertThat(users).extracting("jobTitle").containsOnly("The plumber", "The cook", "The watchman");
        assertThat(users).extracting("yearBorn").containsOnly(1975, 1985, 1995);
    }

    @Test
    void handlesNullFullName() {
        assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy(() ->
                daoTestRule.inTransaction(() -> userDAO.create(new User(null, "The null", 0))));
    }
}
