package com.kotlin.mvvm.domain

import com.kotlin.mvvm.data.QuoteRepository
import com.kotlin.mvvm.data.database.entities.toDatabase
import com.kotlin.mvvm.data.model.QuoteModel
import com.kotlin.mvvm.domain.model.Quote
import javax.inject.Inject

class   GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository){
    suspend operator fun invoke():List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map {it.toDatabase()} )
            quotes
        } else {
            return repository.getAllQuotesFromDatabase()
        }
    }
}