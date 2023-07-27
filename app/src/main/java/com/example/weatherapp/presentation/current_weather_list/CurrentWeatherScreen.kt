package com.example.weatherapp.presentation.current_weather_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.presentation.current_weather_list.composable.CurrentWeatherItem

@Composable
fun CurrentWeatherScreen(
    viewModel: CurrentWeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.currentWeatherItem?.let { CurrentWeatherItem(currentWeather = it) }
    }
    if (state.error.isNotEmpty()) {
        Text(text = state.error, textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize(), fontSize = 20.sp)
    }
    
}