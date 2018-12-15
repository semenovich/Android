package by.bsu.data;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import by.bsu.data.databinding.ActivityMainBinding;
import by.bsu.data.entity.Student;
import by.bsu.data.util.AsyncSaveStudentDatabaseTask;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setStudent(new Student());

        Button saveButton = findViewById(R.id.button);
        saveButton.setOnClickListener(view -> {
            AsyncSaveStudentDatabaseTask task = new AsyncSaveStudentDatabaseTask(binding.getStudent());
            binding.setStudent(new Student());
            task.execute();
        });

        Button findActivityButton = findViewById(R.id.button1);
        findActivityButton.setOnClickListener(view ->
                startActivity(new Intent(this, FindingActivity.class))
        );
    }
}
