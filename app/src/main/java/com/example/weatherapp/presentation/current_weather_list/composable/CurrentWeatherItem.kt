package com.example.weatherapp.presentation.current_weather_list.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.domain.model.current_weather.CurrentWeather
import com.example.weatherapp.utils.LoadFromUrl
import com.example.weatherapp.utils.formatDate

@Composable
fun CurrentWeatherItem(
    currentWeather: CurrentWeather
) {
    Column {
        Text(
            text = formatDate(currentWeather.location.localtime),
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontFamily = FontFamily.SansSerif
        )
        Row(
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Row {
                    Text(
                        text = "${currentWeather.current.tempC.toInt()}",
                        color = Color.White,
                        fontSize = 100.sp,
                        fontWeight = FontWeight.Light,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.4f),
                                offset = Offset(0f, 8f),
                                blurRadius = 10f,
                            )
                        ),
                    )
                    Text(
                        text = "\u2103",
                        color = Color.White,
                        fontSize = 40.sp,
                        modifier = Modifier.padding(top = 20.dp),
                        fontWeight = FontWeight.Light,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.4f),
                                offset = Offset(0f, 8f),
                                blurRadius = 10f,
                            )
                        ),
                    )
                }

                Row {
                    Text(
                        text = "Feels like ${currentWeather.current.feelslikeC}",
                        color = Color.White,
                        fontSize = 15.sp,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.7f),
                                offset = Offset(0f, 8f),
                                blurRadius = 10f,
                            )
                        ),
                    )
                    Text(
                        text = " \u2103",
                        color = Color.White,
                        fontSize = 8.sp,
                        modifier = Modifier.padding(top = 2.dp),
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.7f),
                                offset = Offset(0f, 8f),
                                blurRadius = 10f,
                            )
                        ),
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoadFromUrl(
                    url = "https:${currentWeather.current.conditionDataSource.icon}",
                    width = 100.dp,
                    height = 100.dp,
                )
                Text(
                    text = currentWeather.current.conditionDataSource.text,
                    color = Color.White,
                    fontSize = 15.sp,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.7f),
                            offset = Offset(0f, 8f),
                            blurRadius = 10f,
                        )
                    ),
                )
            }
        }
    }
}