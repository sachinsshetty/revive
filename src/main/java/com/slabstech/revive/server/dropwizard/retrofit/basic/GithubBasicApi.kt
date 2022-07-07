package com.slabstech.revive.server.dropwizard.retrofit.basic

import com.slabstech.revive.server.dropwizard.retrofit.models.Contributor
import com.slabstech.revive.server.dropwizard.retrofit.models.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubBasicApi {
    /**
     * List GitHub repositories of user
     * @param user GitHub Account
     * @return GitHub repositories
     */
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<Repository?>?>?

    /**
     * List Contributors of a GitHub Repository
     * @param user GitHub Account
     * @param repo GitHub Repository
     * @return GitHub Repository Contributors
     */
    @GET("repos/{user}/{repo}/contributors")
    fun listRepoContributors(@Path("user") user: String?, @Path("repo") repo: String?): Call<List<Contributor?>?>?
}