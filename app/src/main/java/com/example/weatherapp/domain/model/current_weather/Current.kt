package com.example.weatherapp.domain.model.current_weather

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentDataSource

data class Current (
    val cloud: Int,
    val conditionDataSource: Condition,
    val feelslikeC: Double,
    val feelslikeF: Double,
    val gustKph: Double,
    val gustMph: Double,
    val humidity: Int,
    val pressureMb: Int,
    val tempC: Float,
    val tempF: Float,
    val windDegree: Float,
    val windDir: String,
    val windKph: Float,
    val windMph: Float,
    val isDay: Int,
    val precipMm: Float,
    val uv: Int,
    val visKm: Int,
)

fun CurrentDataSource.toCurrent(): Current {
    return Current(
        cloud = cloud,
        conditionDataSource = conditionDataSource.toCondition(),
        feelslikeC = feelslikeC,
        feelslikeF = feelslikeF,
        gustKph = gustKph,
        gustMph = gustMph,
        humidity = humidity,
        pressureMb = pressureMb,
        tempC = tempC,
        tempF = tempF,
        windDegree = windDegree,
        windDir = windDir,
        windKph = windKph,
        windMph = windMph,
        isDay = isDay,
        precipMm = precipMm,
        uv = uv,
        visKm = visKm,
    )
}