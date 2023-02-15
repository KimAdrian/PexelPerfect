package com.kimadrian.pexelperfect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kimadrian.pexelperfect.ui.screens.MainScreen
import com.kimadrian.pexelperfect.ui.theme.PexelPerfectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PexelPerfectTheme {
                MainScreen()
            }
        }
    }
}

