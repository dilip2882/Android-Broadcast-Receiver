package com.dilip.custombroadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CustomBroadcastReceiverActivity : AppCompatActivity() {

    private var textView: TextView? = null
    var increment = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_broadcast_receiver)

        textView = findViewById(R.id.textView)

        findViewById<Button>(R.id.send_broadcast).setOnClickListener {
            val intent = Intent("com.example.receiver.EXAMPLE_ACTION")
            intent.putExtra("com.example.EXAMPLE_DATA", "Broadcast Data")
            sendBroadcast(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        var filter = IntentFilter("com.example.receiver.EXAMPLE_ACTION")
        registerReceiver(broadcastReceiver, filter, RECEIVER_EXPORTED)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }

    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if ("com.example.receiver.EXAMPLE_ACTION" == intent?.action) {
                val receiveData = intent.getStringExtra("com.example.EXAMPLE_DATA")
                increment++
                textView?.text = receiveData + increment
            }
        }
    }
}