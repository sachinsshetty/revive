package com.baeldung.retrofitguide

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubServiceGenerator {
    private const val BASE_URL = "https://api.github.com/"
    private val builder = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
    private var retrofit = builder.build()
    private val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
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
            httpClient.addInterceptor(Interceptor { chain ->
                val original = chain.request()
                val builder: okhttp3.Request.Builder = original.newBuilder().header("Authorization", token)
                val request: Request = builder.build()
                chain.proceed(request)
            })
            builder.client(httpClient.build())
            retrofit = builder.build()
        }
        return retrofit.create(serviceClass)
    }
}