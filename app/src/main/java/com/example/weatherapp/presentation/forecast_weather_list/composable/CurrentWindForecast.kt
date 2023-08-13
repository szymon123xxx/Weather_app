package com.example.weatherapp.presentation.forecast_weather_list.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.domain.model.weather_forecast.Forecastday
import com.example.weatherapp.presentation.theme.LightGreyColor
import com.example.weatherapp.utils.LoadFromUrl
import com.example.weatherapp.utils.checkDirection
import com.example.weatherapp.utils.formatDateHH

@Composable
fun CurrentWindForecast(
    currentPrecipitationForecast: Forecastday
) {
    with(currentPrecipitationForecast.hour) {
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
                        modifier = Modifier.padding(start = 20.dp, end = 5.dp),
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
                    direction = direction[it],
                )
            }
        }
    }
}

@Composable
private fun Bar(
    value: Double,
    color: Color,
    maxHeight: Dp,
    maxGraphHeight: Dp,
    time: String,
    direction: String,
) {
    val localDensity = LocalDensity.current

    var columnHeightDp by remember {
        mutableStateOf(0.dp)
    }

    val itemHeight = value / (maxHeight.value + columnHeightDp.value * 3) * maxGraphHeight.value

    LoadFromUrl(url = checkDirection(direction), width = 20.dp, height = 20.dp)
    Text(
        text = value.toInt().toString(),
        color = Color.White,
        fontSize = 13.sp,
        modifier = Modifier.onGloballyPositioned {
            columnHeightDp = with(localDensity) { it.size.height.toDp() }
        }
    )
    Spacer(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .padding(vertical = 5.dp)
            .height(itemHeight.dp)
            .width(30.dp)
            .background(color)
    )
    Text(
        text = formatDateHH(time),
        color = LightGreyColor,
        fontSize = 13.sp,
    )
}