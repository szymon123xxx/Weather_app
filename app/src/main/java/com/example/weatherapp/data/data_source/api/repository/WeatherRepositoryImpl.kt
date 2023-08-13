package com.example.weatherapp.data.data_source.api.repository

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentWeatherDataSource
import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.WeatherForecastDataSource
import com.example.weatherapp.data.data_source.api.endpoints.WeatherApi
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.utils.Constants
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
): WeatherRepository {

    override suspend fun getCurrentWeather(location: String): CurrentWeatherDataSource {
        return weatherApi.currentWeather(location = location, key = Constants.API_KEY)
    }

    override suspend fun getWeatherForecast(
        location: String,
        days: String,
    ): WeatherForecastDataSource {
        return weatherApi.weatherPrecipitation(location = location, days = days, key = Constants.API_KEY)
    }
}