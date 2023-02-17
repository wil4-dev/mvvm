package com.kotlin.mvvm.domain

import com.kotlin.mvvm.data.QuoteRepository
import com.kotlin.mvvm.data.model.QuoteModel

// Caso de uso especíico que llama al repositorio para decirle que recupere de internet todas las citas
class GetQuotesUseCase {
    private val repository = QuoteRepository()
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}