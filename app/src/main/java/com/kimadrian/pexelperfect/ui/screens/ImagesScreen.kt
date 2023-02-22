package com.kimadrian.pexelperfect.ui.screens

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kimadrian.data.models.images.Photo

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagesScreen(modifier: Modifier = Modifier){
    val cellConfiguration = if (LocalConfiguration.current.orientation == ORIENTATION_LANDSCAPE) {
        StaggeredGridCells.Adaptive(minSize = 175.dp)
    } else StaggeredGridCells.Fixed(2)

    LazyVerticalStaggeredGrid(
        columns = cellConfiguration,
        state = rememberLazyStaggeredGridState(),
        content = {

        }
    )
    

}

@Composable
fun ImageItem(modifier: Modifier = Modifier, image: Photo, onClick: (Any) -> Unit){
    AsyncImage(
        model = image.src.tiny,
        contentDescription = image.alt,
        contentScale = ContentScale.Crop,
        modifier = modifier.clickable {
            onClick(image.src)
        }
    )
}

@Composable
fun Loading(modifier: Modifier = Modifier){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = modifier.align(Alignment.Center)
        )
    }

}



