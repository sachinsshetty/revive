package com.slabstech.revive.server.dropwizard.db

import com.slabstech.revive.server.dropwizard.core.User
import io.dropwizard.testing.junit5.DAOTestExtension
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport
import org.assertj.core.api.Assertions
import org.hibernate.exception.ConstraintViolationException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*
import java.util.concurrent.Callable

@ExtendWith(DropwizardExtensionsSupport::class)
internal class UserDAOTest {
    var daoTestRule = DAOTestExtension.newBuilder()
        .addEntityClass(User::class.java)
        .build()
    private var userDAO: UserDAO? = null
    @BeforeEach
    @Throws(Exception::class)
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
}