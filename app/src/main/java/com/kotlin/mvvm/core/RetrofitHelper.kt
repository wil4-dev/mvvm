package com.kotlin.mvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objeto que obtiene peticiones en formato json
object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}