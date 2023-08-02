package com.example.weatherapp.presentation.current_weather_list.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.domain.model.current_weather.CurrentWeather
import com.example.weatherapp.presentation.theme.LightGreyColor

data class WeatherInfo(val label: String, val value: String)

@Composable
fun CurrentDetails(
    currentWeather: CurrentWeather
) {
    val weatherInfoList = with(currentWeather.current) {
        listOf(
            WeatherInfo("Humidity", humidity.toString() + "\u0025"),
            WeatherInfo("Pressure", "$pressureMb mBar"),
            WeatherInfo("Visibility", "$visKm km"),
            WeatherInfo("UV index", uv.toString()),
            WeatherInfo("Wind direction", windDir)
        )
    }

    Text(
        text = "Current details",
        color = Color.White,
        fontSize = 15.sp,
        modifier = Modifier.padding(20.dp),
    )

    Row(modifier = Modifier
        .padding(horizontal = 20.dp)
        .padding(bottom = 30.dp)
    ) {
        repeat(2) { index ->
            Column(
                modifier = Modifier.weight(if (index == 0) 1.5f else 1f),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                weatherInfoList.forEach {
                    Text(
                        text = if (index == 0) it.label else it.value,
                        color = if (index == 0) LightGreyColor else Color.White,
                        fontSize = 15.sp,
                    )
                }
            }
        }
    }

    Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "weatherapi.com",
            color = Color.White,
            fontSize = 15.sp,
            modifier = Modifier.padding(end = 20.dp, bottom = 20.dp)
        )
    }
}