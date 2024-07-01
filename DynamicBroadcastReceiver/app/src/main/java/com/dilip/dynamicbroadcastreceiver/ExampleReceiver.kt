package com.dilip.dynamicbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ExampleReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (Intent.ACTION_TIME_TICK == intent.action) {
            Toast.makeText(context, "Time Updated", Toast.LENGTH_LONG).show()
        } else if (ConnectivityManager.CONNECTIVITY_ACTION == intent.action) {
            val noConnectivity =
                intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
            val message = if (noConnectivity) "Disconnected" else "Connected"
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}

