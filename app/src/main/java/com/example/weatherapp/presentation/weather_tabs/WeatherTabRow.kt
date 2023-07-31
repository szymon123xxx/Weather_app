package com.example.weatherapp.presentation.weather_tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WeatherTabRow(selectedTabIndex: Int, onSelectedTab: (WeatherTabPage) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex
        ) {
            WeatherTabPage.values().forEachIndexed { index, weatherTabPage ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { onSelectedTab(weatherTabPage) },
                    text = { Text(text = weatherTabPage.tab.name) },
                )
            }
        }

    }
}