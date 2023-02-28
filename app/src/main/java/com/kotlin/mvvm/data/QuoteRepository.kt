package com.kotlin.mvvm.data

import com.kotlin.mvvm.data.model.QuoteModel
import com.kotlin.mvvm.data.model.QuoteProvider
import com.kotlin.mvvm.data.network.QuoteService
import javax.inject.Inject

// Repositorio que accedera al model y al network, en este caso recupera las citas de retrofit
class QuoteRepository @Inject constructor(private val api:QuoteService, private val quoteProvider: QuoteProvider){
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}