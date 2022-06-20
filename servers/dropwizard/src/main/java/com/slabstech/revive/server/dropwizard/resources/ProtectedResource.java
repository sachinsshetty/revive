package com.slabstech.revive.server.dropwizard.resources;

import com.slabstech.revive.server.dropwizard.core.User;
import com.slabstech.revive.server.dropwizard.core.UserRole;
import io.dropwizard.auth.Auth;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/protected")
@Produces(MediaType.TEXT_PLAIN)
public class ProtectedResource {

    @PermitAll
    @GET
    public String showSecret(@Auth UserRole userRole) {
        return String.format("Hey there, %s. You know the secret! %d", userRole.getName(), userRole.getId());
    }

    @RolesAllowed("ADMIN")
    @GET
    @Path("admin")
    public String showAdminSecret(@Auth UserRole userRole) {
        return String.format("Hey there, %s. It looks like you are an admin. %d", userRole.getName(), userRole.getId());
    }
}