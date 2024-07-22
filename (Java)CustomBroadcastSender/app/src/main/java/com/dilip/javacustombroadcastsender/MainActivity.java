package com.dilip.javacustombroadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
    private TextView mTextView;
    private final BroadcastReceiver mInnerReceiver = new BroadcastReceiver() {   // anonymous inner class
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.dilip.javacustombroadcastreceiver.ACTION_SEND".equals(intent.getAction())) {

                String intentExtra = intent.getStringExtra("com.dilip.EXTRA_DATA");

                mTextView.setText("Inner broadcast received: " + intentExtra);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);

        registerReceiver(myBroadcastReceiver, intentFilter);

    }

    public void sendBroadcast(View view) {

        Intent intent = new Intent("com.dilip.javacustombroadcastreceiver.ACTION_SEND");
        intent.putExtra("com.dilip.EXTRA_DATA", "Hello from sender app...");

        sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("com.dilip.javacustombroadcastreceiver.ACTION_SEND");
        registerReceiver(mInnerReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mInnerReceiver);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }

/*        public static class MyInnerReceiver extends BroadcastReceiver {   // inner class

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }*/
}