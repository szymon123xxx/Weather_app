package com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source

import com.google.gson.annotations.SerializedName

data class CurrentWeatherDataSource(
    @SerializedName("current")
    val currentDataSource: CurrentDataSource,
    @SerializedName("location")
    val locationDataSource: LocationDataSource,
)