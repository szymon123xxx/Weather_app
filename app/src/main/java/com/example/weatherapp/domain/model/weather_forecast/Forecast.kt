package com.example.weatherapp.domain.model.weather_forecast

import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.ForecastDataSource

data class Forecast(
    val forecastday: List<Forecastday>
)

fun ForecastDataSource.toForecast(): Forecast {
    return Forecast(
        forecastday = forecastday.map { it.toForecastDay() }
    )
}