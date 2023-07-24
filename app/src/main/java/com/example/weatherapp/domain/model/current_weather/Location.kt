package com.example.weatherapp.domain.model.current_weather

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.LocationDataSource

data class Location(
    val country: String,
    val localtime: String,
    val name: String,
)

fun LocationDataSource.toLocation(): Location {
    return Location(
        country = country,
        localtime = localtime,
        name = name,
    )
}
