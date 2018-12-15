package by.bsu.databinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import by.bsu.databinding.R;
import by.bsu.databinding.databinding.ActivityMainBinding;
import by.bsu.databinding.entity.Student;

public class MainActivity extends AppCompatActivity {

    private static final String STUDENT_MODEL = "Student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Student student = new Student();

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setStudent(student);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            intent.putExtra(STUDENT_MODEL, student);
            startActivity(intent);
        });
    }
}