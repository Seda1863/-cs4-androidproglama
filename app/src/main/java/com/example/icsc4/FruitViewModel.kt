package com.example.icsc4

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class FruitViewModel(application: Application) : AndroidViewModel(application) {
    val fruitsList = MutableLiveData<List<Fruit>>()
    val searchResult = MutableLiveData<Fruit>()
    val errorMessage = MutableLiveData<String>()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://berkeozenc.pythonanywhere.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val fruitService: FruitService by lazy {
        retrofit.create(FruitService::class.java)
    }

    fun getAllFruits() {
        viewModelScope.launch {
            try {
                val fruits = fruitService.getAllFruits()
                fruitsList.value = fruits
                Log.d("Fruits", fruits.toString())
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
                Log.e("ERROR", e.toString())
            }
        }
    }

    fun searchFruit(name: String) {
        viewModelScope.launch {
            try {
                val searchResults = fruitService.searchFruit(name)
                if (searchResults.isNotEmpty()) {
                    // İlk eşleşen meyveyi al
                    searchResult.value = searchResults[0]
                } else {
                    errorMessage.value = "Fruit not found: $name"
                }
                Log.d("Search", "Results: ${searchResults.size}")
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
                Log.e("ERROR", e.toString())
            }
        }
    }
} 