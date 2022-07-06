package com.slabstech.revive.server.dropwizard.retrofit.guide

interface GithubUserService {
    @GET("/users")
    fun getUsers(
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): Call<List<GithubUser?>?>?

    @GET("/users/{username}")
    fun getUser(@Path("username") username: String?): Call<GithubUser?>?
}