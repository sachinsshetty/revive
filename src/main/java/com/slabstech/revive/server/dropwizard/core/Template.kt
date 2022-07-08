package com.slabstech.revive.server.dropwizard.core

import java.util.*

class Template(private val content: String, private val defaultName: String) {
    fun render(name: String): String? {
        if (name != null) {
            return String.format(content, name)
        }
        return null;
    }
}