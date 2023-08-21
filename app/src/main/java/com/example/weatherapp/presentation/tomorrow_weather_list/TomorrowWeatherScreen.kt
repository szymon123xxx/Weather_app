package com.example.weatherapp.presentation.tomorrow_weather_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.presentation.forecast_weather_list.ForecastWeatherViewModel
import com.example.weatherapp.presentation.forecast_weather_list.composable.PrecipitationForecast
import com.example.weatherapp.presentation.forecast_weather_list.composable.SunForecast
import com.example.weatherapp.presentation.forecast_weather_list.composable.WindForecast
import com.example.weatherapp.presentation.theme.PrimaryColor
import com.example.weatherapp.presentation.tomorrow_weather_list.composable.TomorrowWeatherDetails

@Composable
fun TomorrowWeatherScreen(
    forecastViewModel2: ForecastWeatherViewModel = hiltViewModel(),
) {
    val forecastState = forecastViewModel2.state.value

    if (forecastState.error.isNotEmpty()) {
        Text(
            text = forecastState.error,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize(),
            fontSize = 20.sp
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            with(forecastState) {
                currentWeatherItem?.forecast?.forecastday?.get(1)?.let { TomorrowWeatherDetails(it) }
                Divider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp)

                currentWeatherItem?.let { PrecipitationForecast(it, "1") }
                Divider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp)

                currentWeatherItem?.forecast?.forecastday?.get(1)?.let { WindForecast(it) }
                Divider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp)

                currentWeatherItem?.forecast?.forecastday?.get(1)?.let { SunForecast(it) }
            }
        }
    }
}