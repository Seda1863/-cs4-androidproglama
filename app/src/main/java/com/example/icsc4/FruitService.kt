package com.example.icsc4

import retrofit2.http.GET
import retrofit2.http.Query

interface FruitService {
    @GET("grocery/")
    suspend fun getAllFruits(): List<Fruit>

    @GET("grocery/")
    suspend fun searchFruit(@Query("name") name: String): List<Fruit>
} 