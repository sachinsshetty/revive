package com.slabstech.revive.server.dropwizard.retrofit.guide

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // Manual creation
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()).build()

        // Using GitHubServiceGenerator
        var service = GitHubServiceGenerator.createService(GithubUserService::class.java)
        val callSync: Call<GithubUser> = service.getGithubUser("sachinsshetty")
        val callAsync: Call<GithubUser> = service.getGithubUser("sachinsshetty")
        try {
            val response: Response<GithubUser> = callSync.execute()
            val GithubUser: GithubUser? = response.body()
            println(GithubUser)
        } catch (ex: IOException) {
        }

        // Execute the call asynchronously. Get a positive or negative callback.
        callAsync.enqueue(object : Callback<GithubUser?> {
            override fun onResponse(call: Call<GithubUser?>?, response: Response<GithubUser?>) {
                val GithubUser: GithubUser? = response.body()
                System.out.println(GithubUser)
            }

            override fun onFailure(call: Call<GithubUser?>?, throwable: Throwable?) {
                println(throwable)
            }
        })
    }
}
