package com.kimadrian.pexelperfect.ui.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kimadrian.pexelperfect.ui.components.BottomBarComponents
import com.kimadrian.pexelperfect.ui.navigation.NavGraph

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) { paddingValues ->
        NavGraph(
            modifier = Modifier.padding(paddingValues),
            navController = navController
        )
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarComponents.AllImages,
        BottomBarComponents.AllVideos
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach {screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )

        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarComponents,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
               Icon(
                   painter = painterResource(id = screen.icon),
                   contentDescription = "Navigation Icon"
               )
        },
        selectedContentColor = Color.White,
        alwaysShowLabel = false,
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = { navController.navigate(screen.route) }
    )
}
