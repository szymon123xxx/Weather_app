package com.example.weatherapp.domain.model.current_weather

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.CurrentDataSource
import com.google.gson.annotations.SerializedName

data class Current (
    val cloud: Int,
    val conditionDataSource: Condition,
    @SerializedName("feelslike_c")
    val feelslikeC: Double,
    @SerializedName("feelslike_f")
    val feelslikeF: Double,
    @SerializedName("gust_kph")
    val gustKph: Double,
    @SerializedName("gust_mph")
    val gustMph: Double,
    val humidity: Int,
    @SerializedName("pressure_mb")
    val pressureMb: Int,
    @SerializedName("temp_c")
    val tempC: Float,
    @SerializedName("temp_f")
    val tempF: Float,
    @SerializedName("wind_degree")
    val windDegree: Float,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_kph")
    val windKph: Float,
    @SerializedName("wind_mph")
    val windMph: Float,
    @SerializedName("is_day")
    val isDay: Int,
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
    )
}