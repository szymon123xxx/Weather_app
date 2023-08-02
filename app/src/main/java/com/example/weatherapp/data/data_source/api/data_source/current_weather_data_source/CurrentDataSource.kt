package com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source

import com.google.gson.annotations.SerializedName

data class CurrentDataSource(
    @SerializedName("air_quality")
    val airQualityDataSource: AirQualityDataSource,
    val cloud: Int,
    @SerializedName("condition")
    val conditionDataSource: ConditionDataSource,
    @SerializedName("feelslike_c")
    val feelslikeC: Double,
    @SerializedName("feelslike_f")
    val feelslikeF: Double,
    @SerializedName("gust_kph")
    val gustKph: Double,
    @SerializedName("gust_mph")
    val gustMph: Double,
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Int,
    @SerializedName("precip_in")
    val precipIn: Float,
    @SerializedName("precip_mm")
    val precipMm: Float,
    @SerializedName("pressure_in")
    val pressureIn: Double,
    @SerializedName("pressure_mb")
    val pressureMb: Int,
    @SerializedName("temp_c")
    val tempC: Float,
    @SerializedName("temp_f")
    val tempF: Float,
    val uv: Int,
    @SerializedName("vis_km")
    val visKm: Int,
    @SerializedName("vis_miles")
    val visMiles: Int,
    @SerializedName("wind_degree")
    val windDegree: Float,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_kph")
    val windKph: Float,
    @SerializedName("wind_mph")
    val windMph: Float,
)