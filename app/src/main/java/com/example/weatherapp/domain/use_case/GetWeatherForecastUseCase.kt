package com.example.weatherapp.domain.use_case

import com.example.weatherapp.data.data_source.api.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.model.weather_forecast.WeatherForecast
import com.example.weatherapp.domain.model.weather_forecast.toForecast
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val weatherRepositoryImpl: WeatherRepositoryImpl,
) {
    operator fun invoke(): Flow<Resource<WeatherForecast>> = flow {
            try {
                emit(Resource.Loading())
                val weatherForecast =
                    weatherRepositoryImpl.getWeatherForecast("Wroclaw", "2").toForecast()
                emit(Resource.Success(data = weatherForecast))
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.localizedMessage ?: "Unexpected http error"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach the server, check your internet connection!"))
            }
        }
}