package com.dilip.custombroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EngineControlViewModel : ViewModel() {
    private val _switchState = MutableStateFlow(false)
    val switchState: StateFlow<Boolean> get() = _switchState

    fun updateSwitchState(isEngineOn: Boolean) {
        _switchState.value = isEngineOn
    }
}

class CustomReceiver(private val viewModel: EngineControlViewModel) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "com.dilip.custombroadcastreceiver.ACTION_SEND") {
            val isEngineOn = intent.getBooleanExtra("DATA", false)
            viewModel.updateSwitchState(isEngineOn)
            showToast(context, isEngineOn)
        }
    }

    private fun showToast(context: Context?, isEngineOn: Boolean) {
        val message = if (isEngineOn) "Engine is ON" else "Engine is OFF"
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}

