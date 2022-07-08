package com.slabstech.revive.server.dropwizard.retrofit.guide

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubUserService {
    @GET("/githubusers")
    fun getGithubUsers(
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): Call<List<GithubUser?>?>?

    @GET("/githubusers/{username}")
    fun getGithubUser(@Path("username") username: String?): Call<GithubUser?>?
}