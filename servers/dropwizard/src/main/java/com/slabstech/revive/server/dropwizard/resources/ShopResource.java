package com.slabstech.revive.server.dropwizard.resources;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.slabstech.revive.server.dropwizard.api.Saying;
import com.slabstech.revive.server.dropwizard.core.Template;
import io.dropwizard.jersey.caching.CacheControl;
import io.dropwizard.jersey.jsr310.LocalDateParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class ShopResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopResource.class);
    private final Template template;
    private final AtomicLong counter;

    public ShopResource(Template template) {
        this.template = template;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed(name = "get-requests-timed")
    @Metered(name = "get-requests-metered")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        return new Saying(counter.incrementAndGet(), template.render(name));
    }

    @POST
    public void receiveHello(Saying saying) {
        LOGGER.info("Received a saying: {}", saying);
    }

    @GET
    @Path("/date")
    @Produces(MediaType.TEXT_PLAIN)
    public String receiveDate(@QueryParam("date") LocalDateParam date) {
        if (date == null) {
            LOGGER.warn("No received date");
            return null;
        }

        LOGGER.info("Received a date: {}", date);
        return date.get().toString();
    }
}
