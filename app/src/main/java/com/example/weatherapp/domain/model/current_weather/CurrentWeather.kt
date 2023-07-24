package com.example.weatherapp.domain.model.current_weather

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentWeatherDataSource

data class CurrentWeather (
    val current: Current,
    val location: Location,
)

fun CurrentWeatherDataSource.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        current = currentDataSource.toCurrent(),
        location = locationDataSource.toLocation(),
    )
}