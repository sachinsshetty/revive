package com.slabstech.revive.server.dropwizard.health

import com.codahale.metrics.health.HealthCheck
import com.slabstech.revive.server.dropwizard.core.Template

class TemplateHealthCheck(private val template: Template) : HealthCheck() {
    @Throws(Exception::class)
    override fun check(): Result {
        template.render("woo")
        template.render("")
        return Result.healthy()
    }
}