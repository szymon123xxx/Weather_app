package com.example.weatherapp.domain.model.weather_forecast

import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.HourDataSource
import com.example.weatherapp.domain.model.current_weather.Condition
import com.example.weatherapp.domain.model.current_weather.toCondition

data class Hour(
    val chanceOfRain: Int,
    val condition: Condition,
    val humidity: Int,
    val tempC: Double,
    val time: String,
    val windDir: String,
    val windKph: Double,
    val precipMm: Double
)

fun HourDataSource.toHour(): Hour {
    return Hour(
        chanceOfRain = chanceOfRain,
        condition = condition.toCondition(),
        humidity = humidity,
        tempC = tempC,
        time = time,
        windDir = windDir,
        windKph = windKph,
        precipMm = precipMm
    )
}