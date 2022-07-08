package com.slabstech.revive.server.dropwizard.retrofit.models

import com.google.gson.annotations.SerializedName

class Contributor {
    @SerializedName("login")
    var name: String? = null
    var contributions: Int? = null
    override fun toString(): String {
        return "Contributer [name=$name, contributions=$contributions]"
    }

    fun getName() {
        TODO("Not yet implemented")
    }

    fun getContributions(): Any {

    }
}