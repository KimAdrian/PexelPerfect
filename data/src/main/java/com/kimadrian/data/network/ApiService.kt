package com.kimadrian.data.network

import com.kimadrian.data.models.images.Images
import com.kimadrian.data.models.videos.Videos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/curated")
    suspend fun getCuratedPhotos(
        @Query("page") page:Int,
        @Query("per_page") per_page: Int): Response<Images>

    @GET("v1/search")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page:Int,
        @Query("per_page") per_page: Int): Response<Images>

    @GET("videos/popular")
    suspend fun getPopularVideos(
        @Query("page") page:Int,
        @Query("per_page") per_page: Int): Response<Videos>

    @GET("videos/search")
    suspend fun searchVideos(
        @Query("query") query: String,
        @Query("page") page:Int,
        @Query("per_page") per_page: Int): Response<Videos>
}