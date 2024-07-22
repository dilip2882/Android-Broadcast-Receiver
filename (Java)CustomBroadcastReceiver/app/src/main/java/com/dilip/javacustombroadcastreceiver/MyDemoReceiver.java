package com.dilip.javacustombroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyDemoReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if ("com.dilip.javacustombroadcastreceiver.ACTION_SEND".equals(intent.getAction())) {

            String extraData = intent.getStringExtra("com.dilip.EXTRA_DATA");

            Toast.makeText(context, "From Receiver App: " + extraData, Toast.LENGTH_LONG).show();

        }
    }
}
