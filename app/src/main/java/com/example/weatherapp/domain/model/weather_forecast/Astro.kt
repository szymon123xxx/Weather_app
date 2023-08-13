package com.example.weatherapp.domain.model.weather_forecast

import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.AstroDataSource


data class Astro(
    val moonPhase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)

fun AstroDataSource.toAstro(): Astro {
    return Astro(
        moonPhase = moonPhase,
        moonrise = moonrise,
        moonset = moonset,
        sunrise = sunrise,
        sunset = sunset,
    )
}