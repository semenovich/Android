package by.bsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String INPUT_RESULT_PARAMETER = "inputResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

    }

    @Override
    public void onClick(View v) {
        Intent returnIntent = new Intent();
        EditText edit = findViewById(R.id.editText);
        returnIntent.putExtra(INPUT_RESULT_PARAMETER, edit.getText().toString());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
