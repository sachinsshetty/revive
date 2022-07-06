package com.slabstech.revive.server.dropwizard.resources

import io.dropwizard.views.View
import java.nio.charset.StandardCharsets
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/views")
class ViewResource {
    @GET
    @Produces("text/html;charset=UTF-8")
    @Path("/utf8.ftl")
    fun freemarkerUTF8(): View {
        return object : View("/views/ftl/utf8.ftl", StandardCharsets.UTF_8) {}
    }

    @GET
    @Produces("text/html;charset=ISO-8859-1")
    @Path("/iso88591.ftl")
    fun freemarkerISO88591(): View {
        return object : View("/views/ftl/iso88591.ftl", StandardCharsets.ISO_8859_1) {}
    }

    @GET
    @Produces("text/html;charset=UTF-8")
    @Path("/utf8.mustache")
    fun mustacheUTF8(): View {
        return object : View("/views/mustache/utf8.mustache", StandardCharsets.UTF_8) {}
    }

    @GET
    @Produces("text/html;charset=ISO-8859-1")
    @Path("/iso88591.mustache")
    fun mustacheISO88591(): View {
        return object : View("/views/mustache/iso88591.mustache", StandardCharsets.ISO_8859_1) {}
    }
}