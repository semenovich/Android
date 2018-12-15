package by.bsu.service;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class TimerService extends Service {

    private static final String SERVICE_TIMER_STOPPED_MESSAGE = "Service timer stopped";
    private static final String SERVICE_WAS_WORKING_FIRST_PART_MESSAGE = "Service worked ";
    private static final String SECONDS_SECOND_PART_MESSAGE = " seconds";

    private static int second;

    private CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            ++second;
        }

        @Override
        public void onFinish() {
            Toast.makeText(TimerService.this, SERVICE_TIMER_STOPPED_MESSAGE, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(TimerService.this,  SERVICE_WAS_WORKING_FIRST_PART_MESSAGE+ second + SECONDS_SECOND_PART_MESSAGE, Toast.LENGTH_SHORT).show();
        timer.cancel();
    }
}
