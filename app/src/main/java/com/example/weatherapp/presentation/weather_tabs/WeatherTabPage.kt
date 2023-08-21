package com.example.weatherapp.presentation.weather_tabs

import com.example.weatherapp.presentation.current_weather_list.CurrentWeatherScreen
import com.example.weatherapp.presentation.tomorrow_weather_list.TomorrowWeatherScreen

enum class WeatherTabPage(val tab: WeatherTab) {
    Today(today),
    Tomorrow(tomorrow),
}

val today = WeatherTab("Today", screen = { CurrentWeatherScreen() })
val tomorrow = WeatherTab("Tomorrow", screen = { TomorrowWeatherScreen() })
