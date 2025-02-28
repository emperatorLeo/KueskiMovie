package com.example.networking.interceptor

import com.example.networking.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class MovieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val urlBuilder = request.newBuilder().header(
            "Authorization",
            BuildConfig.API_KEY
        ).build()

        return chain.proceed(urlBuilder)
    }
}