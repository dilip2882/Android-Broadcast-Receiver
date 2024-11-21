package com.dilip.custombroadcastreceiver

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val customBroadcast = CustomBroadcast()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        val filter = IntentFilter("com.example.receiver.EXAMPLE_ACTION").also {
            registerReceiver(customBroadcast, it, RECEIVER_EXPORTED)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(customBroadcast)
    }
}