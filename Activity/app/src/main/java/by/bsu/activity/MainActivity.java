package by.bsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int INPUT_REQUEST_CODE = 0;
    private static final String INPUT_RESULT_PARAMETER = "inputResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, InputActivity.class);
        startActivityForResult(intent, INPUT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == INPUT_REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                String result = data.getStringExtra(INPUT_RESULT_PARAMETER);
                Toast toast = Toast.makeText(this, result, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
