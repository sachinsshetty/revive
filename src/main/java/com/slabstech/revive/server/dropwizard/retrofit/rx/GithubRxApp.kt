package com.slabstech.revive.server.dropwizard.retrofit.rx

import java.io.IOException

object GitHubRxApp {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val userName = "sachinsshetty"
        GitHubRxService().getTopContributors(userName).subscribe(System.out::println)
    }
}