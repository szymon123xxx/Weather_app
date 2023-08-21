package com.example.weatherapp.presentation.weather_tabs

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.theme.SecondaryColor

@Composable
fun WeatherTabRow(selectedTabIndex: Int, onSelectedTab: (WeatherTabPage) -> Unit, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Green)
            .then(modifier)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = SecondaryColor,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = Color.White,
                    modifier = Modifier
                        .customTabIndicatorOffset(
                            currentTabPosition = tabPositions[selectedTabIndex],
                            tabWidth = 50.dp
                        )
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                )
            }
        ) {
            WeatherTabPage.values().forEachIndexed { index, weatherTabPage ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { onSelectedTab(weatherTabPage) },
                    text = { Text(text = weatherTabPage.tab.name) },
                    selectedContentColor = Color.White
                )
            }
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}