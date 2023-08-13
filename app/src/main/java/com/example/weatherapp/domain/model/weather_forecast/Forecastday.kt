package com.example.weatherapp.domain.model.weather_forecast

import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.ForecastdayDataSource


data class Forecastday(
    val astro: Astro,
    val date: String,
    val day: Day,
    val hour: List<Hour>
)

fun ForecastdayDataSource.toForecastDay(): Forecastday {
    return Forecastday(
        astro = astro.toAstro(),
        date = date,
        day = day.toDay(),
        hour = hour.map { it.toHour() }
    )
}