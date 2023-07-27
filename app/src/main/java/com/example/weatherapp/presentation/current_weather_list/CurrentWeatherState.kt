package com.example.weatherapp.presentation.current_weather_list

import com.example.weatherapp.domain.model.current_weather.CurrentWeather

data class CurrentWeatherState(
    val isLoading: Boolean = false,
    val currentWeatherItem: CurrentWeather? = null,
    val error: String = "",
)
