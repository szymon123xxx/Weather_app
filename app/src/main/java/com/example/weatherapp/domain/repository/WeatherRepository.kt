package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentWeatherDataSource
import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.WeatherForecastDataSource

interface WeatherRepository {
    suspend fun getCurrentWeather(location: String): CurrentWeatherDataSource

    suspend fun getWeatherForecast(
        location: String,
        days: String,
    ): WeatherForecastDataSource
}