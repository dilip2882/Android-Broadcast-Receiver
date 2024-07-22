package com.dilip.javaorderedbroadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int initialCode = getResultCode();
        String initialData = getResultData();
        Bundle bundle = getResultExtras(true);
        String stringExtra = bundle.getString("message_key");

        initialCode++;
        stringExtra += "->BR: Sender";

        String output = "initial Code: " + initialData + "\n" +
                "initial Data: " + initialData + "\n" +
                "string extra: " + stringExtra;

        Toast.makeText(context, output, Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onReceive: "+ output);

        initialData = "BR: Sender";
        bundle.putString("message_key", stringExtra);

        setResult(initialCode, initialData, bundle);

    }
}