package com.slabstech.revive.server.dropwizard

import com.fasterxml.jackson.annotation.JsonProperty
import com.slabstech.revive.server.dropwizard.core.OktaOAuthConfig
import com.slabstech.revive.server.dropwizard.core.Template
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class AppConfiguration : Configuration() {
    @get:JsonProperty
    @set:JsonProperty
    var template: @NotEmpty String? = null
    var oktaOAuth = OktaOAuthConfig()

    @get:JsonProperty
    @set:JsonProperty
    var defaultName: @NotEmpty String? = "Stranger"

    @get:JsonProperty("database")
    @set:JsonProperty("database")
    var dataSourceFactory: @Valid @NotNull DataSourceFactory? = DataSourceFactory()

    @get:JsonProperty("viewRendererConfiguration")
    @set:JsonProperty("viewRendererConfiguration")
    var viewRendererConfiguration: Map<String, Map<String, String>> =
        emptyMap<String, Map<String, String>>()

    fun buildTemplate(): Template? {
        return template?.let { defaultName?.let { it1 -> Template(it, it1) } }
    }
}