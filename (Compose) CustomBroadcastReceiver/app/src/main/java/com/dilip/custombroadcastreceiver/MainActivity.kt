package com.dilip.custombroadcastreceiver

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import com.dilip.custombroadcastreceiver.ui.theme.CustomBroadcastReceiverTheme

class MainActivity : ComponentActivity() {

    private lateinit var broadcastReceiver: CustomReceiver
    private lateinit var engineControlViewModel: EngineControlViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        engineControlViewModel = ViewModelProvider(this)[EngineControlViewModel::class.java]

        val intentFilter = IntentFilter("com.dilip.custombroadcastreceiver.ACTION_SEND").also {
            broadcastReceiver = CustomReceiver(engineControlViewModel)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                registerReceiver(broadcastReceiver, it, RECEIVER_EXPORTED)
            }
        }

        setContent {
            CustomBroadcastReceiverTheme {
                EngineControlScreen(engineControlViewModel)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EngineControlScreen(viewModel: EngineControlViewModel) {
    val switchState by viewModel.switchState.collectAsState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Control state using broadcast",
                        color = Color.White,
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    )

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Switch(
                checked = switchState,
                onCheckedChange = { isChecked ->
                    viewModel.updateSwitchState(isChecked)
                    sendEngineStateBroadcast(context, isChecked)
                }
            )

            EngineControlButton("Turn Engine ON") { sendEngineStateBroadcast(context, true) }
            EngineControlButton("Turn Engine OFF") { sendEngineStateBroadcast(context, false) }
        }
    }

}

@Composable
fun EngineControlButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text)
    }
}

fun sendEngineStateBroadcast(context: Context, isEngineOn: Boolean) {
    val engineStateIntent = Intent("com.dilip.custombroadcastreceiver.ACTION_SEND").apply {
        putExtra("DATA", isEngineOn)
    }
    context.sendBroadcast(engineStateIntent)
}