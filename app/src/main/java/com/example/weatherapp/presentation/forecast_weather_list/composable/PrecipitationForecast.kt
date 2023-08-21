package com.example.weatherapp.presentation.forecast_weather_list.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.weather_forecast.Hour
import com.example.weatherapp.domain.model.weather_forecast.WeatherForecast
import com.example.weatherapp.presentation.theme.LightGreyColor
import com.example.weatherapp.utils.LoadFromUrl
import com.example.weatherapp.utils.formatDateHH

@Composable
fun PrecipitationForecast(
    precipitationForecast: WeatherForecast,
    dayWeather: String,
) {
    val takenPrecipitationForecast =
        precipitationForecast.forecast.forecastday[dayWeather.toInt()]

    Text(
        text = "Precipitation",
        color = Color.White,
        fontSize = 15.sp,
        modifier = Modifier.padding(20.dp),
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
    ) {
        item {
            Column(
                Modifier.padding(start = 20.dp, end = 10.dp)
            ) {
                Text(
                    text = "Chance",
                    color = LightGreyColor,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 35.dp)
                )
                Text(
                    text = "Volume \n (mm)",
                    color = LightGreyColor,
                    fontSize = 15.sp,
                    lineHeight = 15.sp
                )
            }
        }
        items(
            precipitationForecast.forecast.forecastday.size
        ) {
            CreateColumnForEachItemInHour(takenPrecipitationForecast.hour.map { it })
        }
    }

    Row(modifier = Modifier.padding(start = 20.dp, top = 30.dp)) {
        Text(
            text = "Total daily volume",
            color = LightGreyColor,
            fontSize = 15.sp,
            modifier = Modifier.padding(end = 10.dp)
        )

        Text(
            text = "${takenPrecipitationForecast.day.totalPrecipMm}mm",
            color = Color.White,
            fontSize = 15.sp,
        )
    }

    Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "weatherapi.com",
            color = Color.White.copy(alpha = 0.5f),
            fontSize = 15.sp,
            modifier = Modifier.padding(end = 20.dp, bottom = 20.dp, top = 20.dp)
        )
    }
}

@Composable
fun CreateColumnForEachItemInHour(items: List<Hour>) {
    items.forEach { hour ->
        with(hour) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 5.dp),
            ) {

                Text(
                    text = "${chanceOfRain}%",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 10.dp),
                )
                LoadFromUrl(
                    url = when {
                        precipMm < 0.3 -> R.drawable.empty_water_drop
                        precipMm in 0.3..0.49 -> R.drawable.one_quarter_water_drop
                        else -> R.drawable.one_half_water_drop
                    },
                    width = 20.dp,
                    height = 20.dp
                )

                Text(
                    text = precipMm.toString(),
                    color = LightGreyColor,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 10.dp, top = 15.dp)
                )
                Text(
                    text = formatDateHH(time),
                    color = LightGreyColor,
                    fontSize = 15.sp,
                )
            }
        }
    }
}