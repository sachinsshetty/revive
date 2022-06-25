package com.slabstech.revive.server.dropwizard.auth;
import com.slabstech.revive.server.dropwizard.core.UserRole;
import io.dropwizard.auth.Authorizer;

import com.slabstech.revive.server.dropwizard.core.User;

public class AppAuthorizer implements Authorizer<UserRole> {

    @Override
    public boolean authorize(UserRole userRole, String role) {
        return userRole.getRoles() != null && userRole.getRoles().contains(role);
    }
}
