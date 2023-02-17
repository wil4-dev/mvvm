package com.kotlin.mvvm.data

import com.kotlin.mvvm.data.model.QuoteModel
import com.kotlin.mvvm.data.model.QuoteProvider
import com.kotlin.mvvm.data.network.QuoteService

// Repositorio que accedera al model y al network, en este caso recupera las citas de retrofitz
class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}