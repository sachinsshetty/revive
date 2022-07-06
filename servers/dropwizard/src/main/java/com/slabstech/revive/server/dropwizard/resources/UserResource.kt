package com.slabstech.revive.server.dropwizard.resources

import com.slabstech.revive.server.dropwizard.core.User
import com.slabstech.revive.server.dropwizard.db.UserDAO
import com.slabstech.revive.server.dropwizard.views.UserView
import io.dropwizard.hibernate.UnitOfWork
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/user/{userId}")
@Produces(MediaType.APPLICATION_JSON)
class UserResource(private val userDAO: UserDAO) {
    @GET
    @UnitOfWork
    fun getUser(@PathParam("userId") userId: OptionalLong): User {
        return findSafely(userId.orElseThrow { BadRequestException("user ID is required") })
    }

    @GET
    @Path("/view_freemarker")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    fun getUserViewFreemarker(@PathParam("userId") userId: OptionalLong): UserView {
        return UserView(
            UserView.Template.FREEMARKER,
            findSafely(userId.orElseThrow { BadRequestException("user ID is required") })
        )
    }

    @GET
    @Path("/view_mustache")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    fun getUserViewMustache(@PathParam("userId") userId: OptionalLong): UserView {
        return UserView(
            UserView.Template.MUSTACHE,
            findSafely(userId.orElseThrow { BadRequestException("user ID is required") })
        )
    }

    private fun findSafely(userId: Long): User {
        return userDAO.findById(userId).orElseThrow { NotFoundException("No such user.") }
    }

    // TODO implement the functions for ShopModel
    fun buyProduct(productArticleNumber: Long) {}
    fun subscribeEvents(eventName: String?) {}
    fun notifyCustomerProductUpdate(productArticleNumber: Long) {}
    fun notifySellerProductStock(productArticleNumber: Long) {}
}