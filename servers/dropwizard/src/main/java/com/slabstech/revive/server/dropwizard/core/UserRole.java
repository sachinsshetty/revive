package com.slabstech.revive.server.dropwizard.core

import java.security.Principal
import java.util.*

class UserRole : Principal {
    private val name: String
    val roles: Set<String>?

    constructor(name: String) {
        this.name = name
        roles = null
    }

    constructor(name: String, roles: Set<String>?) {
        this.name = name
        this.roles = roles
    }

    override fun getName(): String {
        return name
    }

    val id: Int
        get() = rng.nextInt(100)

    companion object {
        private val rng = Random()
    }
}