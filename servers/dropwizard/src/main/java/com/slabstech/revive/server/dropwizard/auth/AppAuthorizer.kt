package com.slabstech.revive.server.dropwizard.auth

import com.slabstech.revive.server.dropwizard.core.UserRole
import io.dropwizard.auth.Authorizer

class AppAuthorizer : Authorizer<UserRole> {
    override fun authorize(userRole: UserRole, role: String): Boolean {
        return userRole.roles != null && userRole.roles.contains(role)
    }
}