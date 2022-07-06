package com.slabstech.revive.server.dropwizard.health

import com.codahale.metrics.health.HealthCheck
import com.slabstech.revive.server.dropwizard.core.Template
import java.util.*

class TemplateHealthCheck(private val template: Template) : HealthCheck() {
    @Throws(Exception::class)
    override fun check(): Result {
        template.render(Optional.of("woo"))
        template.render(Optional.empty())
        return Result.healthy()
    }
}