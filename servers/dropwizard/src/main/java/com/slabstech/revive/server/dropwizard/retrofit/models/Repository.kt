package com.slabstech.revive.server.dropwizard.retrofit.models

class Repository {
    var name: String? = null
    var description: String? = null
    override fun toString(): String {
        return "Repository [name=$name, description=$description]"
    }
}