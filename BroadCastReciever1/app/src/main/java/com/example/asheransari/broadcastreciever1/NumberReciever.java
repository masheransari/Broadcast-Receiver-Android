package com.example.asheransari.broadcastreciever1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by asher.ansari on 6/29/2017.
 */

public class NumberReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            DBHelper helper = new DBHelper(context);
            SQLiteDatabase database = helper.getWritableDatabase();
            helper.saveNumber(number,database);
            database.close();
            Toast.makeText(context, "Found 2", Toast.LENGTH_SHORT).show();

        }
        Intent i = new Intent(DBContract.UPDATE_UI_FILTER);
        context.sendBroadcast(i);

    }
}
