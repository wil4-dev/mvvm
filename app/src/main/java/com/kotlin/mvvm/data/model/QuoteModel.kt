package com.kotlin.mvvm.data.model

import com.google.gson.annotations.SerializedName

// La información que recuperamos de retrofit lo convertimos en este modelo de datos
data class QuoteModel (
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)