package com.kotlin.mvvm.data

import com.kotlin.mvvm.data.database.dao.QuoteDao
import com.kotlin.mvvm.data.database.entities.QuoteEntity
import com.kotlin.mvvm.data.model.QuoteModel
import com.kotlin.mvvm.data.network.QuoteService
import com.kotlin.mvvm.domain.model.Quote
import com.kotlin.mvvm.domain.model.toDomain
import javax.inject.Inject

// Repositorio que accedera al model y al network, en este caso recupera las citas de retrofit
class QuoteRepository @Inject constructor(private val api:QuoteService, private val quoteDao: QuoteDao){
    suspend fun getAllQuotesFromApi():List<Quote>{
        val response:List<QuoteModel> = api.getQuotes()
        return response.map{it.toDomain()}
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response:List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map{it.toDomain()}
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}
