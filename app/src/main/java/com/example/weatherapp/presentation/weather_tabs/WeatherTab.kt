package com.example.weatherapp.presentation.weather_tabs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class WeatherTab(
    val name: String,
    val icon: ImageVector? = null,
    val screen: @Composable () -> Unit
)
