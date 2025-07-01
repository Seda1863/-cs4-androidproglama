package com.example.icsc4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: FruitViewModel
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[FruitViewModel::class.java]

        val btnListAll = findViewById<Button>(R.id.btnListAll)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val editTextSearch = findViewById<EditText>(R.id.editTextSearch)

        viewModel.fruitsList.observe(this) { fruits ->
            val adapter = moshi.adapter(List::class.java)
            val intent = Intent(this, ListingActivity::class.java)
            intent.putExtra("fruits", adapter.toJson(fruits))
            startActivity(intent)
        }

        viewModel.searchResult.observe(this) { fruit ->
            val adapter = moshi.adapter(Fruit::class.java)
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("fruit", adapter.toJson(fruit))
            startActivity(intent)
        }

        viewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        btnListAll.setOnClickListener {
            viewModel.getAllFruits()
        }

        btnSearch.setOnClickListener {
            val searchText = editTextSearch.text.toString().trim()
            if (searchText.isNotEmpty()) {
                viewModel.searchFruit(searchText)
            } else {
                Toast.makeText(this, "Please enter a fruit name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}