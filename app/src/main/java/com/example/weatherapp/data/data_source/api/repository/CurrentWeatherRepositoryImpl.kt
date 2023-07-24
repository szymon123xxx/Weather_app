package com.example.weatherapp.data.data_source.api.repository

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentWeatherDataSource
import com.example.weatherapp.data.data_source.api.endpoints.WeatherApi
import com.example.weatherapp.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
): CurrentWeatherRepository {

    override suspend fun getCurrentWeather(location: String): List<CurrentWeatherDataSource> {
        return weatherApi.currentWeather(location = location)
    }
}