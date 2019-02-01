package com.rultech.naman.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyBroadCastReceiver extends BroadcastReceiver {
    String TAG="namankashyap";
    @Override
    public void onReceive(Context context, Intent intent) {
        String actionName= intent.getAction();
       /* Bundle bundle=intent.getExtras();
        assert bundle != null;
        String state = bundle.getString(TelephonyManager.EXTRA_STATE);
        Log.w(TAG, state);
        assert state != null;
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String phoneNumber = bundle
                    .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.w(TAG, phoneNumber);
        }
        Intent background = new Intent(context, MyService.class);
                *//*Bundle bundle=intent.getExtras();*//*
        context.startService(background);*/
        Log.i(TAG, "onReceive:  broadcast receiver"+actionName);
        Utiles.scheduleJob(context);

    }
}
