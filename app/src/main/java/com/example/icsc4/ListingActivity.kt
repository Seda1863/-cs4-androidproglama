package com.example.icsc4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Types

class ListingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)

        val fruitsJson = intent.getStringExtra("fruits")
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        
        val listType = Types.newParameterizedType(List::class.java, Fruit::class.java)
        val adapter = moshi.adapter<List<Fruit>>(listType)
        val fruits = adapter.fromJson(fruitsJson) ?: emptyList()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FruitAdapter(fruits) { fruit ->
            val intent = Intent(this, DetailsActivity::class.java)
            val fruitAdapter = moshi.adapter(Fruit::class.java)
            intent.putExtra("fruit", fruitAdapter.toJson(fruit))
            startActivity(intent)
        }
    }
} 