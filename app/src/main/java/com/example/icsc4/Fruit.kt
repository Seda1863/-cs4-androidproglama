package com.example.icsc4

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Fruit(
    @Json(name = "image")
    val image: String,
    
    @Json(name = "name")
    val name: String,
    
    @Json(name = "scientific_name")
    val scientific_name: String,
    
    @Json(name = "calories")
    val calories: Double,
    
    @Json(name = "protein")
    val protein: Double,
    
    @Json(name = "fat")
    val fat: Double,
    
    @Json(name = "carbs")
    val carbs: Double,
    
    @Json(name = "fiber")
    val fiber: Double,
    
    @Json(name = "sugar")
    val sugar: Double,
    
    @Json(name = "vitamin_A")
    val vitaminA: String,
    
    @Json(name = "vitamin_B")
    val vitaminB: String,
    
    @Json(name = "origin")
    val origin: String,
    
    @Json(name = "description")
    val description: String
) 