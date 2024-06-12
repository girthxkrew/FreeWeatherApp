package com.rkm.network.retrofit

import com.google.gson.Gson
import com.rkm.network.models.CurrentWeather.CurrentWeatherResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class CurrentWeatherRemoteDataSourceImplTest{

    private val mockWebServer: MockWebServer = MockWebServer()
    private lateinit var api: CurrentWeatherApi
    private lateinit var dataSource: CurrentWeatherRemoteDataSourceImpl
    private val gson = Gson()
    private val successBodyFilePath = "src/test/resources/currentWeatherResponseBody200.json"
    private val errorBodyFilePath = "src/test/resources/currentWeatherResponseBody400.json"
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        mockWebServer.start()
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrentWeatherApi::class.java)
        dataSource = CurrentWeatherRemoteDataSourceImpl(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `successful current weather response`()  = runTest(dispatcher.scheduler) {
        val responseBody = File(successBodyFilePath).readText()
        val result = gson.fromJson(responseBody, CurrentWeatherResponse::class.java)
        val successResponse = MockResponse().setResponseCode(200).setBody(responseBody)
        mockWebServer.enqueue(successResponse)

        val response = dataSource.getCurrentWeatherByCity("London")

        advanceUntilIdle()

        assertEquals(response.body(), result)
        assertEquals(response.code(), 200)
        assertTrue(response.isSuccessful)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `error current weather response`() = runTest(dispatcher.scheduler) {
        val responseBody = File(errorBodyFilePath).readText()
        val errorResponse = MockResponse().setResponseCode(400).setBody(responseBody)
        mockWebServer.enqueue(errorResponse)

        val response = dataSource.getCurrentWeatherByCity("London")

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