package com.example.alfiq_apps.data.api

import com.example.alfiq_apps.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}