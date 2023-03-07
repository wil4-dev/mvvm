package com.kotlin.mvvm.domain

import com.kotlin.mvvm.data.QuoteRepository
import com.kotlin.mvvm.data.model.QuoteModel
import com.kotlin.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){
    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}