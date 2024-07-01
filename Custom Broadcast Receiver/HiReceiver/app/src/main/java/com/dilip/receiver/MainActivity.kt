package com.dilip.receiver

import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val customBroadcast = CustomBroadcast()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter("com.example.receiver.EXAMPLE_ACTION")
        registerReceiver(customBroadcast, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(customBroadcast)
    }
}