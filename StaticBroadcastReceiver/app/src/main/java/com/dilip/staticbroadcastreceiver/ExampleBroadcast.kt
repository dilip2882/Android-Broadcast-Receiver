package com.dilip.staticbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast

class ExampleBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED == intent?.action &&
            context?.checkSelfPermission(android.Manifest.permission.RECEIVE_BOOT_COMPLETED) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_LONG).show()
        }
    }
}