package com.example.weatherapp.domain.model.weather_forecast

import com.example.weatherapp.data.data_source.api.data_source.weather_forecast_data_source.WeatherForecastDataSource
import com.example.weatherapp.domain.model.current_weather.Current
import com.example.weatherapp.domain.model.current_weather.Location
import com.example.weatherapp.domain.model.current_weather.toCurrent
import com.example.weatherapp.domain.model.current_weather.toLocation

data class WeatherForecast(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

fun WeatherForecastDataSource.toForecast(): WeatherForecast {
    return WeatherForecast(
        current = currentDataSource.toCurrent(),
        forecast = forecastDataSource.toForecast(),
        location = locationDataSource.toLocation(),
    )
}