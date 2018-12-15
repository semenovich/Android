
package by.bsu.databinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import by.bsu.databinding.R;
import by.bsu.databinding.databinding.ActivityViewBinding;
import by.bsu.databinding.entity.Student;

public class ViewActivity extends AppCompatActivity {

    private static final String STUDENT_MODEL = "Student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent intent = getIntent();
        Student student = intent.getParcelableExtra(STUDENT_MODEL);
        ActivityViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view);
        binding.setStudent(student);
    }
}
