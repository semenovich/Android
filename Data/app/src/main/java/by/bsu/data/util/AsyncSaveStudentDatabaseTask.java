package by.bsu.data.util;

import android.os.AsyncTask;

import by.bsu.data.App;
import by.bsu.data.database.StudentDatabase;
import by.bsu.data.entity.Student;
import by.bsu.data.repository.StudentRepository;

public class AsyncSaveStudentDatabaseTask extends AsyncTask<Void, Void, Boolean> {

    private final StudentRepository repository;

    private Student student;

    public AsyncSaveStudentDatabaseTask(Student student) {
        this.student = student;

        StudentDatabase database = App.getInstance().getDatabase();
        repository = database.studentRepository();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        repository.insert(student);
        return true;
    }
}
