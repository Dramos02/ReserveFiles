package com.example.yummly_2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var adapterOrigin: ArrayAdapter<CharSequence>? = null
    private var listOrigin: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_update)

        // Initialize the Spinner
        listOrigin = findViewById(R.id.id_list_origin)

        // Create an ArrayAdapter using the string array and a default spinner layout
        adapterOrigin = ArrayAdapter.createFromResource(
            this,
            R.array.recipeOrigin,
            android.R.layout.simple_spinner_item
        )

        // Specify the layout to use when the list of choices appears
        adapterOrigin?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        listOrigin?.adapter = adapterOrigin
    }
}