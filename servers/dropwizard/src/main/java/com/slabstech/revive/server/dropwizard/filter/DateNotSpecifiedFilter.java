package com.slabstech.revive.server.dropwizard.filter

import java.io.IOException
import javax.ws.rs.WebApplicationException
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

@Provider
class DateNotSpecifiedFilter : ContainerRequestFilter {
    @Throws(IOException::class)
    override fun filter(requestContext: ContainerRequestContext) {
        val dateHeader = requestContext.getHeaderString(HttpHeaders.DATE)
            ?: throw WebApplicationException(
                IllegalArgumentException("Date Header was not specified"),
                Response.Status.BAD_REQUEST
            )
    }
}