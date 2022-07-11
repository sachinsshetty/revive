package com.slabstech.revive.server.dropwizard.retrofit.guide


class GithubUser {
    var login: String? = null
    var id: Long = 0
    var url: String? = null
    var company: String? = null
    var blog: String? = null
    var email: String? = null

    override fun toString(): String {
        return "GithubUser{login=$login, id=$id, url=$url, company=$company, blog=$blog, email=$email}"
    }
}