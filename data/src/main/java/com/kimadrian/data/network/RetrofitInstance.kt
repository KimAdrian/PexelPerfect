package com.kimadrian.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val Base_URL = "https://api.pexels.com/"
private val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val client = OkHttpClient.Builder().apply {
    addInterceptor(AuthInterceptor())
}.build()

object RetrofitInstance {
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(Base_URL)
            .build()
            .create(ApiService::class.java)
    }
}