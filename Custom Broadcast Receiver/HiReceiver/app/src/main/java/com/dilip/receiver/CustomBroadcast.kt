package com.dilip.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if ("com.example.receiver.EXTRA_ACTION" == intent?.action) {
            val receiveData = intent.getStringExtra("com.example.receiver.EXTRA_DATA")
            Toast.makeText(context, "Broadcast Received: $receiveData", Toast.LENGTH_LONG).show()
        }
    }
}