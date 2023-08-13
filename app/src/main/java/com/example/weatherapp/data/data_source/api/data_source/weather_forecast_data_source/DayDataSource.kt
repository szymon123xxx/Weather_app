package com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.ConditionDataSource
import com.google.gson.annotations.SerializedName

data class DayDataSource(
    @SerializedName("avghumidity")
    val avgHumidity: Int,
    @SerializedName("avgtemp_c")
    val avgTempC: Double,
    @SerializedName("avgtemp_f")
    val avgTempF: Double,
    @SerializedName("avgvis_km")
    val avgVisKm: Double,
    @SerializedName("avgvis_miles")
    val avgVisMiles: Int,
    val condition: ConditionDataSource,
    @SerializedName("daily_chance_of_rain")
    val dailyChanceOfRain: Int,
    @SerializedName("daily_chance_of_snow")
    val dailyChanceOfSnow: Int,
    @SerializedName("daily_will_it_rain")
    val dailyWillItRain: Int,
    @SerializedName("daily_will_it_snow")
    val dailyWillItSnow: Int,
    @SerializedName("maxtemp_c")
    val maxTempC: Double,
    @SerializedName("maxtemp_f")
    val maxTempF: Double,
    @SerializedName("maxwind_kph")
    val maxWindKph: Double,
    @SerializedName("maxwind_mph")
    val maxWindMph: Double,
    @SerializedName("mintemp_c")
    val minTempC: Double,
    @SerializedName("mintemp_f")
    val minTempF: Double,
    @SerializedName("totalprecip_in")
    val totalPrecipIn: Double,
    @SerializedName("totalprecip_mm")
    val totalPrecipMm: Double,
    @SerializedName("totalsnow_cm")
    val totalSnowCm: Int,
    val uv: Int
)