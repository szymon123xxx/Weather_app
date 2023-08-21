package com.example.weatherapp.presentation.current_weather_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.R
import com.example.weatherapp.presentation.current_weather_list.composable.CurrentDetails
import com.example.weatherapp.presentation.current_weather_list.composable.CurrentWeatherItem
import com.example.weatherapp.presentation.forecast_weather_list.ForecastWeatherViewModel
import com.example.weatherapp.presentation.forecast_weather_list.composable.PrecipitationForecast
import com.example.weatherapp.presentation.forecast_weather_list.composable.WindForecast
import com.example.weatherapp.presentation.theme.PrimaryColor
import com.example.weatherapp.utils.LoadFromUrl
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun CurrentWeatherScreen(
    currentViewModel: CurrentWeatherViewModel = hiltViewModel(),
    forecastViewModel2: ForecastWeatherViewModel = hiltViewModel(),
) {
    val currentState = currentViewModel.state.value
    val forecastState = forecastViewModel2.state.value
    val precipMm = currentState.currentWeatherItem?.current?.precipMm

    if (currentState.error.isNotEmpty() && forecastState.error.isNotEmpty()) {
        Text(
            text = "${currentState.error} \n ${forecastState.error}",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize(),
            fontSize = 20.sp
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
            ) {
                with(LocalConfiguration.current) {
                    LoadFromUrl(
                        url = R.drawable.weather_night,
                        height = screenHeightDp.dp,
                        width = screenWidthDp.dp
                    )
                }

                currentState.currentWeatherItem?.let { CurrentWeatherItem(currentWeather = it) }

                Row(
                    modifier = Modifier
                        .background(Color.Black.copy(alpha = 0.3f))
                        .align(Alignment.BottomEnd)
                        .padding(vertical = 10.dp, horizontal = 25.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LoadFromUrl(url = R.drawable.weather_cloud, width = 20.dp, height = 20.dp)

                    Text(
                        text = "${
                            if (precipMm != null && ceil(precipMm) == floor(precipMm)) {
                                precipMm.toInt()
                            } else
                                precipMm
                        } mm precipitation amount",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.White.copy(alpha = 0.85f),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            currentState.currentWeatherItem?.let { CurrentDetails(currentWeather = it) }
            Divider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp)

            forecastState.currentWeatherItem?.let { PrecipitationForecast(it, "0") }
            Divider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp)

            forecastState.currentWeatherItem?.forecast?.forecastday?.get(0)?.let {
                    WindForecast(it)
            }
        }
    }
}