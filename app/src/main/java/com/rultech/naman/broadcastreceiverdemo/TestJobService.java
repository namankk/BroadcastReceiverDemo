package com.rultech.naman.broadcastreceiverdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;

public class TestJobService extends JobService {
    String TAG="namankashyap";
    @Override
    public boolean onStartJob(JobParameters params) {
        Intent service = new Intent(getApplicationContext(), MyService.class);
        getApplicationContext().startService(service);
        Utiles.scheduleJob(getApplicationContext()); // reschedule the job
        Log.i(TAG, "onStartJob: job service");
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
