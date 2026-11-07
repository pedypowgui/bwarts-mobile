package com.example.bwarts.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = BwartsOrange,
    onPrimary = BwartsTextWhite,
    secondary = BwartsYellow,
    onSecondary = BwartsDarkBg,
    background = BwartsDarkBg,
    onBackground = BwartsTextWhite,
    surface = BwartsSurface,
    onSurface = BwartsTextWhite,
    surfaceVariant = BwartsCardBg,
    onSurfaceVariant = BwartsTextGray
)

@Composable
fun BwartsTheme(
    darkTheme: Boolean = true, // Force dark theme by default as in BWarts design
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = BwartsSurface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
