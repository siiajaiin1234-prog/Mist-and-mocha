package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = CaramelAmber,
    onPrimary = MochaDark,
    primaryContainer = MochaBrown,
    onPrimaryContainer = CreamText,
    secondary = MistSageLight,
    onSecondary = EspressoNight,
    secondaryContainer = MistSage,
    onSecondaryContainer = Color.White,
    tertiary = AmberBronze,
    background = EspressoNight,
    onBackground = CreamText,
    surface = EspressoSurface,
    onSurface = CreamText,
    surfaceVariant = EspressoCard,
    onSurfaceVariant = MutedCream,
    outline = MochaBrown
)

private val LightColorScheme = lightColorScheme(
    primary = MochaPrimary,
    onPrimary = Color.White,
    primaryContainer = WarmSand,
    onPrimaryContainer = MochaDark,
    secondary = MistSage,
    onSecondary = Color.White,
    secondaryContainer = MistSageContainer,
    onSecondaryContainer = DarkTextPrimary,
    tertiary = CaramelAmber,
    onTertiary = Color.White,
    background = CreamBackground,
    onBackground = DarkTextPrimary,
    surface = CardSurfaceLight,
    onSurface = DarkTextPrimary,
    surfaceVariant = WarmSand,
    onSurfaceVariant = DarkTextSecondary,
    outline = CardBorderLight
)

@Composable
fun MistAndMochaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MistAndMochaTheme(darkTheme = darkTheme, content = content)
}
