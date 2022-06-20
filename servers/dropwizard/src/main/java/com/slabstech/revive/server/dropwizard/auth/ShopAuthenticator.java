package com.slabstech.revive.server.dropwizard.auth;
import com.slabstech.revive.server.dropwizard.core.UserRole;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.util.Maps;
import io.dropwizard.util.Sets;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.slabstech.revive.server.dropwizard.core.User;

public class ShopAuthenticator implements Authenticator<BasicCredentials, UserRole> {
    /**
     * Valid users with mapping user -> roles
     */
    private static final Map<String, Set<String>> VALID_USERS = Collections.unmodifiableMap(Maps.of(
            "guest", Collections.emptySet(),
            "good-guy", Collections.singleton("BASIC_GUY"),
            "chief-wizard", Sets.of("ADMIN", "BASIC_GUY")
    ));

    @Override
    public Optional<UserRole> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if (VALID_USERS.containsKey(credentials.getUsername()) && "secret".equals(credentials.getPassword())) {
            return Optional.of(new UserRole(credentials.getUsername(), VALID_USERS.get(credentials.getUsername())));
        }
        return Optional.empty();
    }
}
