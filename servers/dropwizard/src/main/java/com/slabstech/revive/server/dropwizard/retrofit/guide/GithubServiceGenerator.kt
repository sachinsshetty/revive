package com.slabstech.revive.server.dropwizard.retrofit.guide

import okhttp3.Interceptor

object GitHubServiceGenerator {
    private const val BASE_URL = "https://api.github.com/"
    private val builder: Retrofit.Builder =
        Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
    private var retrofit: Retrofit = builder.build()
    private val httpClient: OkHttpClient.Builder = Builder()
    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    fun <S> createService(serviceClass: Class<S>?): S {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging)
            builder.client(httpClient.build())
            retrofit = builder.build()
        }
        return retrofit.create(serviceClass)
    }

    fun <S> createService(serviceClass: Class<S>?, token: String?): S {
        if (token != null) {
            httpClient.interceptors().clear()
            httpClient.addInterceptor(object : Interceptor() {
                @Throws(IOException::class)
                fun intercept(chain: Interceptor.Chain): Response {
                    val original: Request = chain.request()
                    val builder: Request.Builder = original.newBuilder().header("Authorization", token)
                    val request: Request = builder.build()
                    return chain.proceed(request)
                }
            })
            builder.client(httpClient.build())
            retrofit = builder.build()
        }
        return retrofit.create(serviceClass)
    }
}