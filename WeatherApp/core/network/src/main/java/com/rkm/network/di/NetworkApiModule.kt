package com.rkm.network.di

import com.rkm.network.BuildConfig
import com.rkm.network.interceptors.WeatherInterceptor
import com.rkm.network.retrofit.CurrentWeatherApi
import com.rkm.network.retrofit.ForecastedWeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkApiModule {

    @Provides
    fun providesWeatherInterceptor(): Interceptor {
        return WeatherInterceptor(BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        weatherInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(weatherInterceptor)
        }.build()
    }

    @Singleton
    @Provides
    fun providesRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesCurrentWeatherApi(
        retrofit: Retrofit
    ): CurrentWeatherApi {
        return retrofit.create(CurrentWeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun providesForecastedWeatherApi(retrofit: Retrofit): ForecastedWeatherApi {
        return retrofit.create(ForecastedWeatherApi::class.java)
    }

}