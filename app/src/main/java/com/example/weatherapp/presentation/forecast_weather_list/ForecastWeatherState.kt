package com.example.weatherapp.presentation.forecast_weather_list

import com.example.weatherapp.domain.model.weather_forecast.WeatherForecast

data class ForecastWeatherState (
    val isLoading: Boolean = false,
    val currentWeatherItem: WeatherForecast? = null,
    val error: String = "",
)