package com.dilip.javaexplicitbroadcastsender;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

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

        Intent intent = new Intent("com.dilip.javaexplicitbroadcastsender.ACTION_SEND");

//        intent.setPackage("com.dilip.javaexplicitbroadcastreceiver");

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfos = packageManager.queryBroadcastReceivers(intent, 0);

        for (ResolveInfo info : resolveInfos) {
            ComponentName componentName = new
                    ComponentName(info.activityInfo.packageName, info.activityInfo.name);
            intent.setComponent(componentName);
            sendBroadcast(intent);
        }

//        Intent intent = new Intent(this, MyBroadcastReceiver.class);
//        intent.setClass(this, MyBroadcastReceiver.class);

//        Intent intent = new Intent();
//        ComponentName componentName = new ComponentName("com.dilip.javaexplicitbroadcastreceiver", "com.dilip.javaexplicitbroadcastreceiver.MyDemoReceiver");
//        intent.setComponent(componentName);

//        sendBroadcast(intent);
    }

}