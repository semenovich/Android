package by.bsu.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v) {
        Intent intent = new Intent(this, TimerService.class);
        if (v.getId() == R.id.start) {
            startService(intent);
        } else {
            stopService(intent);
        }
    }

}
