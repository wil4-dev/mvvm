package com.kotlin.mvvm.data.network

import com.kotlin.mvvm.core.RetrofitHelper
import com.kotlin.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Servicio para hacer el llamado al servidor (retrofit) obteniendo un response en un hilo secundario
class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}