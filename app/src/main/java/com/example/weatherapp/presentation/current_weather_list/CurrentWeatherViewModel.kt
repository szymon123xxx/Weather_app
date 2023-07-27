package com.example.weatherapp.presentation.current_weather_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.use_case.GetCurrentWeatherUseCase
import com.example.weatherapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CurrentWeatherState())
    val state: State<CurrentWeatherState> = _state

    init {
        getCurrentWeather()
    }

    private fun getCurrentWeather() {
        getCurrentWeatherUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        CurrentWeatherState(currentWeatherItem = result.data)
                }

                is Resource.Error -> {
                    _state.value = CurrentWeatherState(
                        error = result.message
                            ?: "Unexpected Error in ${CurrentWeatherViewModel::class.java}"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CurrentWeatherState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}