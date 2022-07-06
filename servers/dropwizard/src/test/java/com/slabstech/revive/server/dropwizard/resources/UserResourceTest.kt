package com.slabstech.revive.server.dropwizard.resources

import com.slabstech.revive.server.dropwizard.core.User
import com.slabstech.revive.server.dropwizard.db.UserDAO
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport
import io.dropwizard.testing.junit5.ResourceExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import java.util.*
import javax.ws.rs.core.Response

/**
 * Unit tests for [UserResource].
 */
@ExtendWith(DropwizardExtensionsSupport::class)
internal class UserResourceTest {
    @AfterEach
    fun tearDown() {
        Mockito.reset(DAO)
    }

    @get:Test
    val userSuccess: Unit
        get() {
            val user = User()
            user.id = 1L
            Mockito.`when`(DAO.findById(1L)).thenReturn(Optional.of(user))
            val found = RULE.target("/user/1").request().get(
                User::class.java
            )
            Assertions.assertThat(found.id).isEqualTo(user.id)
            Mockito.verify(DAO).findById(1L)
        }

    @get:Test
    val userNotFound: Unit
        get() {
            Mockito.`when`(DAO.findById(2L)).thenReturn(Optional.empty())
            val response = RULE.target("/user/2").request().get()
            Assertions.assertThat(response.statusInfo.statusCode).isEqualTo(Response.Status.NOT_FOUND.statusCode)
            Mockito.verify(DAO).findById(2L)
        }

    companion object {
        private val DAO = Mockito.mock(UserDAO::class.java)
        val RULE = ResourceExtension.builder()
            .addResource(UserResource(DAO))
            .build()
    }
}