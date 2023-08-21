package com.example.weatherapp.presentation.forecast_weather_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.use_case.GetWeatherForecastUseCase
import com.example.weatherapp.presentation.current_weather_list.CurrentWeatherViewModel
import com.example.weatherapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ForecastWeatherViewModel @Inject constructor(
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(ForecastWeatherState())
    val state: State<ForecastWeatherState> = _state

    init {
        getWeatherForecast()
    }

    private fun getWeatherForecast() {
        getWeatherForecastUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ForecastWeatherState(currentWeatherItem = result.data)
                }

                is Resource.Loading -> {
                    _state.value = ForecastWeatherState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = ForecastWeatherState(
                        error = result.message
                            ?: "Unexpected Error in ${CurrentWeatherViewModel::class.java}"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}