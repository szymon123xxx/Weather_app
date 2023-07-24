package com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source

import com.google.gson.annotations.SerializedName

data class LocationDataSource(
    val country: String,
    val lat: Int,
    val localtime: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    val lon: Int,
    val name: String,
    val region: String,
    @SerializedName("tz_id")
    val tzId: String,
)