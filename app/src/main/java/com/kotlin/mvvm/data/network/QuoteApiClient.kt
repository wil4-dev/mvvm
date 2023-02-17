package com.kotlin.mvvm.data.network

import com.kotlin.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

// Interface con el método get, creado para obtener los datos en una lista
interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}