package com.example.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import com.example.weatherapp.presentation.weather_tabs.WeatherTabPage
import com.example.weatherapp.presentation.weather_tabs.WeatherTabRow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                var tabPage by remember { mutableStateOf(WeatherTabPage.Today) }
                var componentHeight by remember { mutableStateOf(0.dp) }
                val density = LocalDensity.current
                Scaffold(
                    topBar = {
                        WeatherTabRow(
                            selectedTabIndex = tabPage.ordinal,
                            onSelectedTab = { tabPage = it },
                            modifier = Modifier.onGloballyPositioned {
                                componentHeight = with(density) {
                                    it.size.height.toDp()
                                }
                            }
                        )
                    }, content = {
                        Column(
                            modifier = Modifier
                                .padding(it)
                                .fillMaxHeight(),
                        ) {
                            tabPage.tab.screen.invoke()
                        }
                    }
                )
            }
        }
    }
}
