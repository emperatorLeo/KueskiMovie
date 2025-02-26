package com.example.networking.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class MovieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val urlBuilder = request.url.newBuilder().addQueryParameter(
            "Authorization",
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzYTQwNTk3ZWEyYmRiYWNjZWFiZDAyNjFmNDRhY2UyYSIsIm5iZiI6MTUzOTg2NTQ3NC42NTI5OTk5LCJzdWIiOiI1YmM4N2I4MjBlMGEyNjM2MmUwMTY4OTYiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.X2Hh8UTlLT6vVZry05wBIxxdmqRjc9ZiOvERcnPxKfw"
        ).build()

        val modifiedRequest = request.newBuilder().url(urlBuilder).build()
        return chain.proceed(modifiedRequest)
    }
}