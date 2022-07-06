package com.slabstech.revive.server.dropwizard.retrofit.rx;

import com.slabstech.revive.server.dropwizard.retrofit.models.Contributor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

class GitHubRxService {

    private GitHubRxApi gitHubApi;

    GitHubRxService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

        gitHubApi = retrofit.create(GitHubRxApi.class);
    }

    Observable<String> getTopContributors(String userName) {
        return gitHubApi.listRepos(userName).flatMapIterable(x -> x).flatMap(repo -> gitHubApi.listRepoContributors(userName, repo.getName())).flatMapIterable(x -> x).filter(c -> c.getContributions() > 100)
                .sorted((a, b) -> b.getContributions() - a.getContributions()).map(Contributor::getName).distinct();
    }
}package com.slabstech.revive.server.dropwizard.retrofit.rx

import retrofit2.Retrofit

internal class GitHubRxService {
    private val gitHubApi: GitHubRxApi

    init {
        val retrofit: Retrofit =
            Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
        gitHubApi = retrofit.create(GitHubRxApi::class.java)
    }

    fun getTopContributors(userName: String?): Observable<String> {
        return gitHubApi.listRepos(userName).flatMapIterable { x -> x }
            .flatMap { repo -> gitHubApi.listRepoContributors(userName, repo.getName()) }.flatMapIterable { x -> x }
            .filter { c -> c.getContributions() > 100 }
            .sorted { a, b -> b.getContributions() - a.getContributions() }.map { obj: Contributor -> obj.getName() }
            .distinct()
    }
}
