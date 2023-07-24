package com.example.weatherapp.data.data_source.api.endpoints

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentWeatherDataSource
import com.example.weatherapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface WeatherApi {

    @Headers("api-key: " + Constants.API_KEY)
    @GET("/current")
    suspend fun currentWeather(@Path("q") location: String): List<CurrentWeatherDataSource>

}