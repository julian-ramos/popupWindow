package com.ramos.julian.popupwindow;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
    String TAG = "dialog";
    Button dfragbutton;
    Button alertdfragbutton;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main);

        registerReceiver(broadcastReceiver, new IntentFilter(DFragment.BROADCAST_ACTION));



        // Locate the button in activity_main.xml
        dfragbutton = (Button) findViewById(R.id.button);
        alertdfragbutton = (Button) findViewById(R.id.button2);

        // Capture button clicks
        dfragbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                DFragment dFragment = new DFragment();
                // Show DialogFragment
                dFragment.show(fm, "Dialog Fragment");

            }
        });

        // Capture button clicks
        alertdfragbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                AlertDFragment alertdFragment = new AlertDFragment();
                // Show Alert DialogFragment
                alertdFragment.show(fm, "Alert Dialog Fragment");
                alertdFragment.setCancelable(false);

            }
        });
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            updateUI(intent);
            if (intent.getStringExtra("score")!=null){
                Log.d(TAG,"Got message from dialog "+intent.getStringExtra("score"));
            }


        }
    };



}