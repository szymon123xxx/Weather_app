package com.example.weatherapp.data.data_source.api.endpoints

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentWeatherDataSource
import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.WeatherForecastDataSource
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current.json")
    suspend fun currentWeather(
        @Query("q") location: String,
        @Query("key") key: String,
    ): CurrentWeatherDataSource

    @GET("forecast.json")
    suspend fun weatherPrecipitation(
        @Query("q") location: String,
        @Query("days") days: String,
        @Query("key") key: String,
    ): WeatherForecastDataSource
}