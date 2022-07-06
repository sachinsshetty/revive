package com.slabstech.revive.server.dropwizard.auth

import com.slabstech.revive.server.dropwizard.core.UserRole
import io.dropwizard.auth.AuthenticationException
import io.dropwizard.auth.Authenticator
import io.dropwizard.auth.basic.BasicCredentials
import io.dropwizard.util.Maps
import io.dropwizard.util.Sets
import java.util.*

class AppAuthenticator : Authenticator<BasicCredentials, UserRole> {
    @Throws(AuthenticationException::class)
    override fun authenticate(credentials: BasicCredentials): Optional<UserRole> {
        return if (VALID_USERS.containsKey(credentials.username) && "secret" == credentials.password) {
            Optional.of(
                UserRole(
                    credentials.username,
                    VALID_USERS[credentials.username]
                )
            )
        } else Optional.empty()
    }

    companion object {
        /**
         * Valid users with mapping user -> roles
         */
        private val VALID_USERS = Collections.unmodifiableMap(
            Maps.of(
                "guest", emptySet(),
                "good-guy", setOf("BASIC_GUY"),
                "chief-wizard", Sets.of("ADMIN", "BASIC_GUY")
            )
        )
    }
}