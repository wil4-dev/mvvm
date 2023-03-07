package com.kotlin.mvvm.data.network

import com.kotlin.mvvm.core.RetrofitHelper
import com.kotlin.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// Servicio para hacer el llamado al servidor (retrofit) obteniendo un response en un hilo secundario
class QuoteService @Inject constructor(private val api:QuoteApiClient) {

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}