package com.dilip.dynamicbroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dilip.dynamicbroadcastreceiver.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var exampleReceiver: ExampleReceiver? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        exampleReceiver = ExampleReceiver()

        // Create an IntentFilter to specify the broadcasts we're interested in
        val filter = IntentFilter()
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        filter.addAction(Intent.ACTION_TIME_TICK)

        // Register the receiver with the system
        registerReceiver(exampleReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unregister the receiver when the activity is destroyed
        unregisterReceiver(exampleReceiver)
    }
}
