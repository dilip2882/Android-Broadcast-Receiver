package com.dilip.javaexplicitbroadcastsender;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);

    }

    public void sendBroadcast(View view) {

//        Intent intent = new Intent(this, MyBroadcastReceiver.class);
//        intent.setClass(this, MyBroadcastReceiver.class);

        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.dilip.javaexplicitbroadcastreceiver", "com.dilip.javaexplicitbroadcastreceiver.MyDemoReceiver");
        intent.setComponent(componentName);

        sendBroadcast(intent);
    }

}