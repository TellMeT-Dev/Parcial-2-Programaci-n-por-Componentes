package com.example.parcial.network
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


class LoicationService {
    private val BASE_URL = "http://localhost:8000/docs"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create()).baseUrl(BASE_URL).build()

    interface ParcialAPIServide {
        @GET("health")
        fun getHealth(): String
    }
}