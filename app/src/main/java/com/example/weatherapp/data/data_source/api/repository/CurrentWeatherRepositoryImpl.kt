package com.example.weatherapp.data.data_source.api.repository

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentWeatherDataSource
import com.example.weatherapp.data.data_source.api.endpoints.WeatherApi
import com.example.weatherapp.domain.repository.CurrentWeatherRepository
import com.example.weatherapp.utils.Constants
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
): CurrentWeatherRepository {

    override suspend fun getCurrentWeather(location: String): CurrentWeatherDataSource {
        return weatherApi.currentWeather(location = location, key = Constants.API_KEY)
    }
}