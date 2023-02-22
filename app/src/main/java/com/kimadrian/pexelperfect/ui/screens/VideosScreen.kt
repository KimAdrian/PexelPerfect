package com.kimadrian.pexelperfect.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kimadrian.data.models.videos.Video
import com.kimadrian.pexelperfect.R

@Composable
fun VideosScreen(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        content = {

        }
    )
}

@Composable
fun VideoThumbnailItem(modifier: Modifier = Modifier, video: Video) {
    Box {
        AsyncImage(
            model = video.image,
            contentDescription = "Thumbnail",
            modifier = modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.video_24),
            contentDescription = "Image icon",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 4.dp, bottom = 4.dp)
        )
    }
}