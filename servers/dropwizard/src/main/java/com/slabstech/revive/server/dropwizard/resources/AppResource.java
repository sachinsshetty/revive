package com.slabstech.revive.server.dropwizard.resources

import com.codahale.metrics.annotation.Metered
import com.codahale.metrics.annotation.Timed
import com.slabstech.revive.server.dropwizard.api.Saying
import com.slabstech.revive.server.dropwizard.core.Template
import io.dropwizard.jersey.caching.CacheControl
import io.dropwizard.jersey.jsr310.LocalDateParam
import org.slf4j.LoggerFactory
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
class AppResource(private val template: Template) {
    private val counter: AtomicLong

    init {
        counter = AtomicLong()
    }

    @GET
    @Timed(name = "get-requests-timed")
    @Metered(name = "get-requests-metered")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    fun sayHello(@QueryParam("name") name: Optional<String?>?): Saying {
        return Saying(counter.incrementAndGet(), template.render(name))
    }

    @POST
    fun receiveHello(saying: Saying?) {
        LOGGER.info("Received a saying: {}", saying)
    }

    @GET
    @Path("/date")
    @Produces(MediaType.TEXT_PLAIN)
    fun receiveDate(@QueryParam("date") date: LocalDateParam?): String? {
        if (date == null) {
            LOGGER.warn("No received date")
            return null
        }
        LOGGER.info("Received a date: {}", date)
        return date.get().toString()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(AppResource::class.java)
    }
}