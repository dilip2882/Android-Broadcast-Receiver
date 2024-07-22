package com.dilip.javaorderedbroadcastreceiver;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyDemoReceiver myDemoReceiver = new MyDemoReceiver();
    MyDemoReceiver2 mReceiver = new MyDemoReceiver2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter("com.dilip.javaorderedbroadcastreceiver.ACTION_SEND");
        intentFilter.setPriority(80);
        registerReceiver(mReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    public void sendBroadcast(View view) {

    }
}