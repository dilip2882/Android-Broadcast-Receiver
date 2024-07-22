package com.dilip.javaexplicitbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyDemoReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Explicit demo receiver called: Receiver App", Toast.LENGTH_SHORT).show();
    }
}
