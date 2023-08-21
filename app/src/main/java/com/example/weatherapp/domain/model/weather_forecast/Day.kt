package com.example.weatherapp.domain.model.weather_forecast

import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.DayDataSource

data class Day(
    val dailyChanceOfRain: Int,
    val maxTempC: Double,
    val maxWindKph: Double,
    val minTempC: Double,
    val totalPrecipMm: Double,
    val humidity: Int,
    val visibility: Double,
    val uv: Int
)

fun DayDataSource.toDay(): Day {
    return Day(
        dailyChanceOfRain = dailyChanceOfRain,
        maxTempC = maxTempC,
        maxWindKph = maxWindKph,
        minTempC = minTempC,
        totalPrecipMm = totalPrecipMm,
        humidity = avgHumidity,
        visibility = avgVisKm,
        uv = uv,
    )
}