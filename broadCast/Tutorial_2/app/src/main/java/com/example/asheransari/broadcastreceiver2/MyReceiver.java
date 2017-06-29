package com.example.asheransari.broadcastreceiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by asher.ansari on 6/29/2017.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "INtent Detected Message.. : "+intent.getAction()
                , Toast.LENGTH_SHORT).show();
    }
}
