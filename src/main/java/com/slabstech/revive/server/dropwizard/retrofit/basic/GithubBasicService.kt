package com.slabstech.revive.server.dropwizard.retrofit.basic

import com.slabstech.revive.server.dropwizard.retrofit.models.Contributor
import com.slabstech.revive.server.dropwizard.retrofit.models.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.stream.Collectors
import java.util.stream.Stream

internal class GitHubBasicService {
    private val gitHubApi: GithubBasicApi

    init {
        val retrofit =
            Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create())
                .build()
        gitHubApi = retrofit.create(GithubBasicApi::class.java)
    }

    @Throws(IOException::class)
    fun getTopContributors(userName: String?): MutableList<String?>? {
        var repos = gitHubApi.listRepos(userName)!!
            .execute().body()
        repos = repos ?: emptyList<Repository>()
        return repos.stream().flatMap { repo: Repository? -> getContributors(userName, repo) }
            .sorted { a: Contributor?, b: Contributor? -> (b!!.contributions?.minus(a!!.contributions!!) ?: b.contributions) as Int }
            .map { obj: Contributor? -> obj!!.name }.distinct().sorted().collect(Collectors.toList())
    }

    private fun getContributors(userName: String?, repo: Repository?): Stream<Contributor?> {
        var contributors: List<Contributor?>? = null
        try {
            contributors = gitHubApi.listRepoContributors(userName, repo!!.name)!!.execute().body()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        contributors = contributors ?: emptyList<Contributor>()
        return contributors.stream().filter { c: Contributor? -> c!!.contributions!! > 100 }
    }
}