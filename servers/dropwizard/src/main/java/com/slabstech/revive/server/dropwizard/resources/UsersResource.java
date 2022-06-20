package com.slabstech.revive.server.dropwizard.resources;

import com.slabstech.revive.server.dropwizard.core.User;
import com.slabstech.revive.server.dropwizard.db.UserDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private final UserDAO peopleDAO;

    public UsersResource(UserDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @POST
    @UnitOfWork
    public User createUser(@Valid User user) {
        return peopleDAO.create(user);
    }

    @GET
    @UnitOfWork
    public List<User> listUsers() {
        return peopleDAO.findAll();
    }
}