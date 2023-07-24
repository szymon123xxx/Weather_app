package com.example.weatherapp.domain.model.current_weather

import com.example.weatherapp.data.data_source.api.data_source.current_weather_data_source.ConditionDataSource

data class Condition (
    val icon: String,
    val text: String,
)

fun ConditionDataSource.toCondition(): Condition {
    return Condition(
        icon = icon,
        text = text,
    )
}