package com.example.weatherapp.presentation.weather_tabs

enum class WeatherTabPage(val tab: WeatherTab) {
    Today(today),
    Tomorrow(tomorrow),
    Future(future),
}

val today = WeatherTab("Today", screen = { })
val tomorrow = WeatherTab("Tomorrow", screen = { })
val future = WeatherTab("3 Days", screen = { })