package com.slabstech.revive.server.dropwizard.retrofit.guide

import okhttp3.OkHttpClient

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // Manual creation
        val httpClient: OkHttpClient.Builder = Builder()
        val retrofit: Retrofit =
            Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()).build()
        var service: GithubUserService = retrofit.create(GithubUserService::class.java)
        // Using GitHubServiceGenerator
        service = GitHubServiceGenerator.createService(GithubUserService::class.java)
        val callSync: Call<GithubUser> = service.getGithubUser("eugenp")
        val callAsync: Call<GithubUser> = service.getGithubUser("eugenp")
        try {
            val response: Response<GithubUser> = callSync.execute()
            val GithubUser: GithubUser = response.body()
            println(GithubUser)
        } catch (ex: IOException) {
        }

        // Execute the call asynchronously. Get a positive or negative callback.
        callAsync.enqueue(object : Callback<GithubUser?>() {
            fun onResponse(call: Call<GithubUser?>?, response: Response<GithubUser?>) {
                val GithubUser: GithubUser = response.body()
                System.out.println(user)
            }

            fun onFailure(call: Call<GithubUser?>?, throwable: Throwable?) {
                println(throwable)
            }
        })
    }
}