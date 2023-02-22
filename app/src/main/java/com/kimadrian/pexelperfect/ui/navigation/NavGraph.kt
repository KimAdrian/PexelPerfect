package com.kimadrian.pexelperfect.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kimadrian.pexelperfect.ui.components.BottomBarComponents
import com.kimadrian.pexelperfect.ui.screens.ImagesScreen
import com.kimadrian.pexelperfect.ui.screens.PlayVideoScreen
import com.kimadrian.pexelperfect.ui.screens.VideosScreen
import com.kimadrian.pexelperfect.ui.screens.ViewImageScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarComponents.AllImages.route) {
        composable(route = BottomBarComponents.AllImages.route) {
            ImagesScreen()
        }
        composable(route = BottomBarComponents.AllVideos.route) {
            VideosScreen()
        }
        composable(route = Screens.ViewImage.name){
            ViewImageScreen()
        }
        composable(route = Screens.PlayVideo.name){
            PlayVideoScreen()
        }
    }

}

enum class Screens{
    ViewImage,
    PlayVideo
}