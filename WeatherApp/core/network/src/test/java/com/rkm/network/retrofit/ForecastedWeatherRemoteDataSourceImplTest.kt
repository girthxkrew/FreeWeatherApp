package com.rkm.network.retrofit

import com.google.gson.Gson
import com.rkm.network.models.ForecastedWeather.ForecastedWeatherResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class ForecastedWeatherRemoteDataSourceImplTest {

    private val mockWebServer: MockWebServer = MockWebServer()
    private lateinit var api: ForecastedWeatherApi
    private lateinit var dataSource: ForecastedWeatherRemoteDataSourceImpl
    private val gson = Gson()
    private val successBodyFilePath = "src/test/resources/forecastedWeatherResponseBody200.json"
    private val errorBodyFilePath = "src/test/resources/forecastedWeatherResponseBody400.json"
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        mockWebServer.start()
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ForecastedWeatherApi::class.java)
        dataSource = ForecastedWeatherRemoteDataSourceImpl(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `successful forecasted weather response`()  = runTest(dispatcher.scheduler) {
        val responseBody = File(successBodyFilePath).readText()
        val result = gson.fromJson(responseBody, ForecastedWeatherResponse::class.java)
        val successResponse = MockResponse().setResponseCode(200).setBody(responseBody)
        mockWebServer.enqueue(successResponse)

        val response = dataSource.getForecastedWeatherByCity("London", "yes", 10)

        advanceUntilIdle()

        assertEquals(response.body(), result)
        assertEquals(response.code(), 200)
        assertTrue(response.isSuccessful)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `error forecasted weather response`() = runTest(dispatcher.scheduler) {
        val responseBody = File(errorBodyFilePath).readText()
        val errorResponse = MockResponse().setResponseCode(400).setBody(responseBody)
        mockWebServer.enqueue(errorResponse)

        val response = dataSource.getForecastedWeatherByCity("", "yes", 10)

        advanceUntilIdle()

        assertFalse(response.isSuccessful)
        assertEquals(response.code(), 400)
        assertTrue(response.errorBody()?.string().equals(responseBody))
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}