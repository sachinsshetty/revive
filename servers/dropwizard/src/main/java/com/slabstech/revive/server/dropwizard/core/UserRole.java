package com.slabstech.revive.server.dropwizard.core;

import java.security.Principal;
import java.util.Random;
import java.util.Set;

public class UserRole implements Principal {
    private static final Random rng = new Random();

    private final String name;

    private final Set<String> roles;

    public UserRole(String name) {
        this.name = name;
        this.roles = null;
    }

    public UserRole(String name, Set<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return rng.nextInt(100);
    }

    public Set<String> getRoles() {
        return roles;
    }
}
