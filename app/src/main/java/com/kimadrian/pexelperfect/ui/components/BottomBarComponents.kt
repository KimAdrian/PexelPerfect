package com.kimadrian.pexelperfect.ui.components

import com.kimadrian.pexelperfect.R

sealed class BottomBarComponents(
    val route: String,
    val title: String,
    val icon: Int
) {
    object AllImages: BottomBarComponents(
        route = "images",
        title = "Image",
        icon = R.drawable.image_24
    )
    object AllVideos: BottomBarComponents(
        route = "videos",
        title = "Videos",
        icon = R.drawable.video_24
    )
}

