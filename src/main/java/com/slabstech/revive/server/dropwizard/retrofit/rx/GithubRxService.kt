package com.slabstech.revive.server.dropwizard.retrofit.rx;

import com.slabstech.revive.server.dropwizard.retrofit.models.Contributor
import com.slabstech.revive.server.dropwizard.retrofit.models.Repository
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.functions.Func1
import rx.functions.Func2


internal class GitHubRxService {
    private val gitHubApi: GitHubRxApi

    init {
        val retrofit =
            Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
        gitHubApi = retrofit.create(GitHubRxApi::class.java)
    }

    fun getTopContributors(userName: String?): Observable<Any>? {
        return gitHubApi.listRepos(userName)!!.flatMapIterable { x: List<Repository?>? -> x }
            .flatMap { repo: Repository? ->
                gitHubApi.listRepoContributors(
                    userName,
                    repo!!.name
                )
            }
        //.flatMapIterable { x: List<Contributor?>? -> x }.filter(
        //                Func1 { c: Contributor? -> c!!.getContributions() > 100 })
        //            .sorted(Func2 { a: Contributor?, b: Contributor? -> b!!.getContributions() - a!!.getContributions() })
        //            .map<Any>(Contributor::getName).distinct()
    }
}
