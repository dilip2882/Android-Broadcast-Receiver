package com.dilip.mybroadcastsender

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var button: Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)

        button?.setOnClickListener {
            val intent = Intent("com.dilip.mybroadcastsender.ACTION_SEND")
            intent.putExtra("com.dilip.mybroadcastsender.EXTRA_DATA", "sender send data")
            sendBroadcast(intent)
        }
    }
}