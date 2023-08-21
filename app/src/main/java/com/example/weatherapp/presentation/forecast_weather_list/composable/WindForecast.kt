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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.domain.model.weather_forecast.Forecastday
import com.example.weatherapp.presentation.theme.LightGreyColor
import com.example.weatherapp.utils.LoadFromUrl
import com.example.weatherapp.utils.checkDirection

@Composable
fun WindForecast(
    precipitationForecast: Forecastday,
) {
    with(precipitationForecast.hour) {
        Row {
            Column {
                Text(
                    text = "Wind",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(20.dp),
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = first().windKph.toInt()
                            .toString(),
                        color = Color.Cyan,
                        fontSize = 35.sp,
                        modifier = Modifier.padding(start = 20.dp, end = 10.dp),
                        fontStyle = FontStyle.Normal
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        LoadFromUrl(
                            url = checkDirection(first().windDir),
                            width = 20.dp,
                            height = 20.dp
                        )
                        Text(
                            text = "km/h",
                            color = LightGreyColor,
                            fontSize = 15.sp,
                            lineHeight = 15.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        CreateWindRow(
            values = map { it.windKph },
            maxListValue = map { it.windKph }.max().dp,
            maxGraphHeight = 150.dp,
            time = map { it.time },
            direction = map { it.windDir }
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
internal fun CreateWindRow(
    modifier: Modifier = Modifier,
    values: List<Double>,
    maxListValue: Dp,
    maxGraphHeight: Dp,
    time: List<String>,
    direction: List<String>,
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
                    color = Color.Cyan,
                    maxHeight = maxListValue,
                    maxGraphHeight = maxGraphHeight,
                    time = time[it],
                    data = direction[it],
                    isWind = true,
                )
            }
        }
    }
}