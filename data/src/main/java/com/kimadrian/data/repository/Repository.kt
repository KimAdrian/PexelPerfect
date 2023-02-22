package com.kimadrian.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kimadrian.data.models.images.Photo
import com.kimadrian.data.models.videos.Video
import com.kimadrian.data.paging.ImagePagingDataSource
import com.kimadrian.data.paging.SearchImagePagingDataSource
import com.kimadrian.data.paging.SearchVideoPagingDataSource
import com.kimadrian.data.paging.VideoPagingDataSource
import kotlinx.coroutines.flow.Flow

class Repository {
    fun getCuratedPhotos(): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = 30, enablePlaceholders = false),
            pagingSourceFactory = {
                ImagePagingDataSource()
            }
        ).flow
    }

    fun searchImage(query: String): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = 30, enablePlaceholders = false),
            pagingSourceFactory = {
                SearchImagePagingDataSource(query = query)
            }
        ).flow
    }

    fun getPopularVideos(): Flow<PagingData<Video>> {
        return Pager(
            config = PagingConfig(pageSize = 30, enablePlaceholders = false),
            pagingSourceFactory = {
                VideoPagingDataSource()
            }
        ).flow
    }

    fun searchVideos(query: String): Flow<PagingData<Video>> {
        return Pager(
            config = PagingConfig(pageSize = 30, enablePlaceholders = false),
            pagingSourceFactory = {
                SearchVideoPagingDataSource(query = query)
            }
        ).flow
    }
}