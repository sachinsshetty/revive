package com.slabstech.revive.server.dropwizard.retrofit.basic

import java.io.IOException
import java.util.function.Consumer

object GitHubBasicApp {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val userName = "sachinsshetty"
        val topContributors = GitHubBasicService().getTopContributors(userName)
        if (topContributors != null) {
            topContributors.forEach(Consumer { x: String? -> println(x) })
        }
    }
}