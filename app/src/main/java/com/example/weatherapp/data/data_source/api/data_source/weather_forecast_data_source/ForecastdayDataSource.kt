package com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source

import com.google.gson.annotations.SerializedName

data class ForecastdayDataSource(
    val astro: AstroDataSource,
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    val day: DayDataSource,
    val hour: List<HourDataSource>
)