package com.slabstech.revive.server.dropwizard.filter

import javax.ws.rs.container.DynamicFeature
import javax.ws.rs.container.ResourceInfo
import javax.ws.rs.core.FeatureContext
import javax.ws.rs.ext.Provider

@Provider
class DateRequiredFeature : DynamicFeature {
    override fun configure(resourceInfo: ResourceInfo, context: FeatureContext) {
        if (resourceInfo.resourceMethod.getAnnotation(DateRequired::class.java) != null) {
            context.register(DateNotSpecifiedFilter::class.java)
        }
    }
}