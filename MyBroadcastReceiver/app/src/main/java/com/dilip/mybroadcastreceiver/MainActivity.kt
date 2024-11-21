package com.dilip.mybroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var increment = 0
    private val broad = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                "com.dilip.mybroadcastsender.ACTION_SEND" -> {
                    val string = intent.getStringExtra("com.dilip.mybroadcastsender.EXTRA_DATA")
                    Log.d("DILIP", "onReceive: $string")
                    Toast.makeText(context, "Receiver app receive ${string}", Toast.LENGTH_LONG)
                        .show()
                    increment++
                    findViewById<TextView>(androidx.core.R.id.text).text = "$string + $increment"
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter("com.dilip.mybroadcastsender.ACTION_SEND").also {
            registerReceiver(broad, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broad)
    }
}