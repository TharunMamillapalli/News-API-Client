package com.example.newsapiclient.data.api


import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets

class NewsAPIServiceTest {
    private lateinit var service:NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server=MockWebServer()
        service=Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream=javaClass.classLoader!!.getResourceAsStream(fileName)
        val source=inputStream.source().buffer()
        val mockResponse=MockResponse()
        mockResponse.setBody(source.readString(StandardCharsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receiveExpected(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody=service.getTopHeadlines("us",1).body()
            val request=server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=84362a5511754a5295dce974b5828219")

        }
    }
    @Test
    fun getTopHeadLines_receivedRequest_correctPageSize(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody=service.getTopHeadlines("us",1).body()
            val articleList=responseBody!!.articles
            assertThat(articleList.size).isEqualTo(20)
        }
    }
}