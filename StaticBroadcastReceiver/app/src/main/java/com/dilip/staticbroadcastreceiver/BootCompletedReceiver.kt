package com.dilip.staticbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED == intent?.action) {
            // Optional permission check
            if (context?.checkSelfPermission(android.Manifest.permission.RECEIVE_BOOT_COMPLETED) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(context, "Device Booted Successfully!", Toast.LENGTH_LONG).show()
            } else {
                // Handle permission not granted case (e.g., log a warning)
            }
        }
    }
}
