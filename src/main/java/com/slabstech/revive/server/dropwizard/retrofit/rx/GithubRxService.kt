package com.slabstech.revive.server.dropwizard.retrofit.rx;

import com.slabstech.revive.server.dropwizard.retrofit.models.Contributor
import com.slabstech.revive.server.dropwizard.retrofit.rx.GitHubRxApi;
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

class GitHubRxService {
    private val gitHubApi: GitHubRxApi

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
        gitHubApi = retrofit.create(GitHubRxApi::class.java)
    }

    fun getTopContributors(userName: String?): Observable<Unit>?

    {
        return gitHubApi.listRepos(userName)?.flatMapIterable { x -> x }
            .flatMap { repo -> gitHubApi.listRepoContributors(userName, repo.getName()) }.flatMapIterable { x -> x }
            .filter { c -> c.getContributions() > 100 }
            .sorted { a, b -> b.getContributions() - a.getContributions() }.map { obj: Contributor? -> obj.getName() }
            .distinct()
    }
}

