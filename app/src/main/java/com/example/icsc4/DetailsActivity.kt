package com.example.icsc4

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val fruitJson = intent.getStringExtra("fruit")
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter = moshi.adapter(Fruit::class.java)
        val fruit = adapter.fromJson(fruitJson) ?: return

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textName = findViewById<TextView>(R.id.textName)
        val textScientificName = findViewById<TextView>(R.id.textScientificName)
        val textOrigin = findViewById<TextView>(R.id.textOrigin)
        val textCalories = findViewById<TextView>(R.id.textCalories)
        val textProtein = findViewById<TextView>(R.id.textProtein)
        val textFat = findViewById<TextView>(R.id.textFat)
        val textCarbs = findViewById<TextView>(R.id.textCarbs)
        val textFiber = findViewById<TextView>(R.id.textFiber)
        val textSugar = findViewById<TextView>(R.id.textSugar)
        val vitaminsContainer = findViewById<LinearLayout>(R.id.vitaminsContainer)
        val textDescription = findViewById<TextView>(R.id.textDescription)

        Glide.with(this)
            .load(fruit.image)
            .centerCrop()
            .into(imageView)

        textName.text = fruit.name
        textScientificName.text = fruit.scientific_name
        textOrigin.text = fruit.origin
        textCalories.text = "${fruit.calories}"
        textProtein.text = "${fruit.protein}g"
        textFat.text = "${fruit.fat}g"
        textCarbs.text = "${fruit.carbs}g"
        textFiber.text = "${fruit.fiber}g"
        textSugar.text = "${fruit.sugar}g"
        textDescription.text = fruit.description


        val vitaminAView = TextView(this)
        vitaminAView.text = "Vitamin A: ${fruit.vitaminA}"
        vitaminsContainer.addView(vitaminAView)

        val vitaminBView = TextView(this)
        vitaminBView.text = "Vitamin B: ${fruit.vitaminB}"
        vitaminsContainer.addView(vitaminBView)
    }
} 