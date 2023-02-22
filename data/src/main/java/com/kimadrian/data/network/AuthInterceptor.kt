package com.kimadrian.data.network

import com.kimadrian.data.utils.apiKey
import okhttp3.Interceptor
import okhttp3.Response

//Interceptor will add api key to header
class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", apiKey)
            .build()
        return chain.proceed(request)
    }
}