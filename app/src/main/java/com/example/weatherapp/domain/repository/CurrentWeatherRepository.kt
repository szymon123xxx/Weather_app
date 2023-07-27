package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentWeatherDataSource

interface CurrentWeatherRepository {
    suspend fun getCurrentWeather(location: String): CurrentWeatherDataSource
}