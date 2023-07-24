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
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CurrentWeatherListState())
    val state: State<CurrentWeatherListState> = _state

    init {
        getCurrentWeather()
    }

    private fun getCurrentWeather() {
        getCurrentWeatherUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Timber.d("ELOELO SUCCESS ${result.data}")
                    _state.value =
                        CurrentWeatherListState(currentWeatherList = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    Timber.d("ELOELO ERROR ${result.message}")
                    _state.value = CurrentWeatherListState(
                        error = result.message
                            ?: "Unexpected Error in ${CurrentWeatherViewModel::class.java}"
                    )
                }

                is Resource.Loading -> {
                    Timber.d("ELOELO Loading")
                    _state.value = CurrentWeatherListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}