package by.bsu.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import by.bsu.data.entity.Student;
import by.bsu.data.repository.StudentRepository;

public class FindingActivity extends AppCompatActivity {

    private static final String NO_MATCHES_MESSAGE = "No matches :(";

    private List<Student> students;
    private StudentRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding);

        repository = App.getInstance().getDatabase().studentRepository();

        Button findActivityButton = findViewById(R.id.button2);
        findActivityButton.setOnClickListener(view -> {

            students = repository.getBySurnameLike(
                    ((EditText) findViewById(R.id.editText3)).getText().toString()
            );
            showStudents();

        });

        Button createStudentButton = findViewById(R.id.button3);
        createStudentButton.setOnClickListener(view ->
                startActivity(new Intent(this, MainActivity.class))
        );
    }

    private void showStudents() {
        if (students != null && students.size() > 0) {
            ListView lv = findViewById(R.id.lv);
            lv.setAdapter(
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students)
            );
        } else {
            Toast.makeText(this, NO_MATCHES_MESSAGE, Toast.LENGTH_LONG).show();
        }
    }
}
