package com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source

import com.google.gson.annotations.SerializedName

data class AirQualityDataSource(
    val co: Double,
    @SerializedName("gb_defra_index")
    val gbDefraIndex: Int,
    val no2: Double,
    val o3: Double,
    val pm10: Int,
    @SerializedName("pm2_5")
    val pm25: Double,
    val so2: Int,
    @SerializedName("us_epa_index")
    val usEpaIndex: Int,
)