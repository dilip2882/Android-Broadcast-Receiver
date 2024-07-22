package com.dilip.javaorderedbroadcastsender;

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

        Intent intent = new Intent("com.dilip.javaorderedbroadcastreceiver.ACTION_SEND");

        intent.setPackage("com.dilip.javaorderedbroadcastreceiver");

        Bundle bundle = new Bundle();
        bundle.putString("message_key", "Start");

        sendOrderedBroadcast(intent, null, new MyBroadcastReceiver(), null,
                RESULT_CANCELED, "Start", bundle);

    }

}