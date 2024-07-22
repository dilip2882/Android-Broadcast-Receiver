package com.dilip.javaorderedbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyDemoReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//        Toast.makeText(context, "My Demo Receiver1: Receiver App", Toast.LENGTH_SHORT).show();

        if (isOrderedBroadcast()) {

            int initialCode = getResultCode();
            String initialData = getResultData();
            Bundle bundle = getResultExtras(true);
            String stringExtra = bundle.getString("message_key");

            initialCode++;
            stringExtra += "->BR1";

            String output = "initial Code: "+ initialData+"\n"+
                    "initial Data: "+initialData+"\n"+
                    "string extra: "+stringExtra;

            Toast.makeText(context, output, Toast.LENGTH_SHORT).show();
            Log.d("TAG", "onReceive: "+ output);


            initialData = "BR1";
            bundle.putString("message_key", stringExtra);

            setResult(initialCode, initialData, bundle);
        }
    }
}
