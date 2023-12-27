package com.example.tutorial7

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        val viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        // Set the initial value
        textView.text = viewModel.count.value.toString()

        button.setOnClickListener {
            viewModel.increment()
        }

        // Observe changes in count
        viewModel.count.observe(this) { count ->
            textView.text = count.toString()
        }
    }
}
