package com.slabstech.revive.server.dropwizard.retrofit.guide

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubUserService {
    @GET("/users")
    fun getUsers(
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): Call<List<GithubUser?>?>?

    @GET("/users/{username}")
    fun getUser(@Path("username") username: String?): Call<GithubUser?>?
    abstract fun getGithubUser(s: String): Call<GithubUser>
}