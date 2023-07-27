package com.example.weatherapp.presentation.current_weather_list.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.model.current_weather.CurrentWeather

@Composable
fun CurrentWeatherItem(
    currentWeather: CurrentWeather
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = currentWeather.location.name
        )

    }
}