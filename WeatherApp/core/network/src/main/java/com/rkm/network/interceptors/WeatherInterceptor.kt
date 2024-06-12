package com.rkm.network.interceptors

import com.rkm.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class WeatherInterceptor(private val api_key: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("key", api_key).build()
        return chain.proceed(builder.build())
    }
}