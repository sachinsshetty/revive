package com.slabstech.revive.server.dropwizard.resources;

import com.slabstech.revive.server.dropwizard.core.User;
import com.slabstech.revive.server.dropwizard.db.UserDAO;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.core.Response;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link UserResource}.
 */
@ExtendWith(DropwizardExtensionsSupport.class)
class UserResourceTest {
    private static final UserDAO DAO = mock(UserDAO.class);
    public static final ResourceExtension RULE = ResourceExtension.builder()
            .addResource(new UserResource(DAO))
            .build();

    @AfterEach
    void tearDown() {
        reset(DAO);
    }

    @Test
    void getUserSuccess() {
        final User user = new User();
        user.setId(1L);

        when(DAO.findById(1L)).thenReturn(Optional.of(user));

        User found = RULE.target("/user/1").request().get(User.class);

        assertThat(found.getId()).isEqualTo(user.getId());
        verify(DAO).findById(1L);
    }

    @Test
    void getUserNotFound() {
        when(DAO.findById(2L)).thenReturn(Optional.empty());
        final Response response = RULE.target("/user/2").request().get();

        assertThat(response.getStatusInfo().getStatusCode()).isEqualTo(Response.Status.NOT_FOUND.getStatusCode());
        verify(DAO).findById(2L);
    }
}
