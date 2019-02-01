package com.rultech.naman.broadcastreceiverdemo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private boolean isRunning;
    private Context context;
    private Thread backgroundThread;
    String TAG="namankashyap";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        this.context = this;
        this.isRunning = false;
        Log.i(TAG, "onCreate: service");
        this.backgroundThread = new Thread(myTask);
    }

    private Runnable myTask = new Runnable() {
        public void run() {
            // Do something here
            /*Toast.makeText(context,"done",Toast.LENGTH_SHORT).show();*/
            Log.i(TAG, "run: onCreate ");
            stopSelf();
        }
    };

    @Override
    public void onDestroy() {
        this.isRunning = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!this.isRunning) {
            this.isRunning = true;
            this.backgroundThread.start();
        }
        Log.i(TAG, "onStartCommand: ");
        return START_STICKY;
    }
}
