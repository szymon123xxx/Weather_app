package com.example.weatherapp.presentation.forecast_weather_list.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.theme.LightGreyColor
import com.example.weatherapp.utils.LoadFromUrl
import com.example.weatherapp.utils.checkDirection
import com.example.weatherapp.utils.formatDateHH

@Composable
fun Bar(
    value: Double,
    color: Color,
    maxHeight: Dp,
    maxGraphHeight: Dp,
    time: String,
    data: String,
    isWind: Boolean
) {
    val localDensity = LocalDensity.current

    var columnHeightDp by remember {
        mutableStateOf(0.dp)
    }

    val itemHeight = value / (maxHeight.value + columnHeightDp.value * 3) * maxGraphHeight.value

    LoadFromUrl(url = if (isWind) checkDirection(data) else "https:$data", width = 20.dp, height = 20.dp)
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