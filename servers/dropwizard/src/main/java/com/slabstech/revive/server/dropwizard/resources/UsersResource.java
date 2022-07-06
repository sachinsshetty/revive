package com.slabstech.revive.server.dropwizard.resources

import com.slabstech.revive.server.dropwizard.core.User
import com.slabstech.revive.server.dropwizard.db.UserDAO
import io.dropwizard.hibernate.UnitOfWork
import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
class UsersResource(private val peopleDAO: UserDAO) {
    @POST
    @UnitOfWork
    fun createUser(user: @Valid User?): User {
        return peopleDAO.create(user)
    }

    @GET
    @UnitOfWork
    fun listUsers(): List<User> {
        return peopleDAO.findAll()
    }
}