package com.kimadrian.data.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kimadrian.data.models.images.Photo
import com.kimadrian.data.network.RetrofitInstance

class ImagePagingDataSource: PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage = params.key ?: 1
            val response = RetrofitInstance.apiService.getCuratedPhotos(page = nextPage, per_page = 30)
            var nextPageNumber: Int? = null

            if (response.body() != null) {
                val uri = Uri.parse(response.body()?.next_page)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(
                data = response.body()!!.photos,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}