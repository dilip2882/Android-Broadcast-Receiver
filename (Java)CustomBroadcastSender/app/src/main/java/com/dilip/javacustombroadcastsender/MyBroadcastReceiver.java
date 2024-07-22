package com.dilip.javacustombroadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {

            boolean booleanExtra = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if (!booleanExtra) {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }
        } else if (Intent.ACTION_TIME_TICK.equals(intent.getAction())) {
            Toast.makeText(context, "Time incremented", Toast.LENGTH_SHORT).show();
        }

    }
}