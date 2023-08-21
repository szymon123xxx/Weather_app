package com.example.weatherapp.presentation.forecast_weather_list.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.domain.model.weather_forecast.Forecastday
import com.example.weatherapp.presentation.theme.LightGreyColor

@Composable
fun SunForecast(
    precipitationForecast: Forecastday,
) {
    with(precipitationForecast) {
        Row {
            Column {
                Text(
                    text = "Sun",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp),
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text(
                            text = "max",
                            color = LightGreyColor,
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 20.dp, end = 8.dp),
                            fontStyle = FontStyle.Normal
                        )
                        Text(
                            text = "min",
                            color = LightGreyColor,
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 20.dp, end = 8.dp),
                            fontStyle = FontStyle.Normal
                        )

                    }
                    Column {
                        Text(
                            text = "${day.maxTempC} \u2103",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Normal
                        )
                        Text(
                            text = "${day.minTempC} \u2103",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Normal
                        )
                    }
                }

            }
        }
        CreateSunRow(
            values = hour.map { it.tempC },
            maxListValue = hour.map { it.tempC }.max().dp,
            maxGraphHeight = 150.dp,
            time = hour.map { it.time },
            icons = hour.map { it.condition.icon }
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
fun CreateSunRow(
    modifier: Modifier = Modifier,
    values: List<Double>,
    maxListValue: Dp,
    maxGraphHeight: Dp,
    time: List<String>,
    icons: List<String>,
) {
    LazyRow(
        modifier = modifier.then(
            Modifier
                .wrapContentWidth()
                .height(maxGraphHeight)
                .padding(start = 20.dp)
        ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        items(values.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Bar(
                    value = values[it],
                    color = Color.Yellow,
                    maxHeight = maxListValue,
                    maxGraphHeight = maxGraphHeight,
                    time = time[it],
                    data = icons[it],
                    isWind = false,
                )
            }
        }
    }
}