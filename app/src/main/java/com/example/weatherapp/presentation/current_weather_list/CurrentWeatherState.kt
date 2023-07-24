package com.example.weatherapp.presentation.current_weather_list

import com.example.weatherapp.domain.model.current_weather.CurrentWeather

data class CurrentWeatherListState(
    val isLoading: Boolean = false,
    val currentWeatherList: List<CurrentWeather> = emptyList(),
    val error: String = "",
)
