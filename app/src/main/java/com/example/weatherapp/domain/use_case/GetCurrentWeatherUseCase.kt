package com.example.weatherapp.domain.use_case

import com.example.weatherapp.data.data_source.api.repository.CurrentWeatherRepositoryImpl
import com.example.weatherapp.domain.model.current_weather.CurrentWeather
import com.example.weatherapp.domain.model.current_weather.toCurrentWeather
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val currentWeatherRepositoryImpl: CurrentWeatherRepositoryImpl
) {
    operator fun invoke(): Flow<Resource<CurrentWeather>> = flow {
        try {
            emit(Resource.Loading())
            val currentWeather =
                currentWeatherRepositoryImpl.getCurrentWeather("Wroclaw").toCurrentWeather()
            emit(Resource.Success(currentWeather))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected http error"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach the server, check your internet connection!"))
        }
    }
}