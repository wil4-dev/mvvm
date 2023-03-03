package com.kotlin.mvvm.domain.model

import com.kotlin.mvvm.data.database.entities.QuoteEntity
import com.kotlin.mvvm.data.model.QuoteModel

// modelo de datos que llega del dominio
data class Quote (val quote:String, val author:String, val user:String)

fun QuoteModel.toDomain() = Quote(quote, author, user = "Wilson")

fun QuoteEntity.toDomain() = Quote(quote, author, user)
