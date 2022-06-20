package com.slabstech.revive.server.dropwizard.resources;

import com.slabstech.revive.server.dropwizard.core.User;
import com.slabstech.revive.server.dropwizard.db.UserDAO;
import com.slabstech.revive.server.dropwizard.views.UserView;

import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.OptionalLong;

@Path("/user/{userId}")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GET
    @UnitOfWork
    public User getUser(@PathParam("userId") OptionalLong userId) {
        return findSafely(userId.orElseThrow(() -> new BadRequestException("user ID is required")));
    }

    @GET
    @Path("/view_freemarker")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public UserView getUserViewFreemarker(@PathParam("userId") OptionalLong userId) {
        return new UserView(UserView.Template.FREEMARKER, findSafely(userId.orElseThrow(() -> new BadRequestException("user ID is required"))));
    }

    @GET
    @Path("/view_mustache")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public UserView getUserViewMustache(@PathParam("userId") OptionalLong userId) {
        return new UserView(UserView.Template.MUSTACHE, findSafely(userId.orElseThrow(() -> new BadRequestException("user ID is required"))));
    }

    private User findSafely(long userId) {
        return userDAO.findById(userId).orElseThrow(() -> new NotFoundException("No such user."));
    }

    // TODO implement the functions for ShopModel
    public void buyProduct(long productArticleNumber){}

    public void subscribeEvents(String eventName){}

    public void notifyCustomerProductUpdate(long productArticleNumber){}

    public void notifySellerProductStock(long productArticleNumber){}
}

