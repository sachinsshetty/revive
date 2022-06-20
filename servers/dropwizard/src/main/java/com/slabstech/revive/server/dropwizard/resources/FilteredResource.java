package com.slabstech.revive.server.dropwizard.resources;

import com.slabstech.revive.server.dropwizard.filter.DateRequired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/filtered")
public class FilteredResource {

    @GET
    @DateRequired
    @Path("hello")
    public String sayHello() {
        return "hello";
    }
}