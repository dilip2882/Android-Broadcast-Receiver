package com.dilip.staticbroadcastreceiver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
                // Register receiver dynamically
                val filter = IntentFilter(Intent.ACTION_BOOT_COMPLETED)
                registerReceiver(ExampleBroadcast(), filter)
        */

    }
}