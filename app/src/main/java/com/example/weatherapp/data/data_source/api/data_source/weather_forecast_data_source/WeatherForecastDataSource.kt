package com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentDataSource
import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.LocationDataSource
import com.google.gson.annotations.SerializedName

data class WeatherForecastDataSource(
    @SerializedName("current")
    val currentDataSource: CurrentDataSource,
    @SerializedName("forecast")
    val forecastDataSource: ForecastDataSource,
    @SerializedName("location")
    val locationDataSource: LocationDataSource
)