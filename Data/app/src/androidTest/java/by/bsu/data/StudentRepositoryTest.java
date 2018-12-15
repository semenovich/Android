package by.bsu.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import by.bsu.data.database.StudentDatabase;
import by.bsu.data.entity.Student;
import by.bsu.data.repository.StudentRepository;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class StudentRepositoryTest {

    private static final String SURNAME = "Qwerty";
    private static final String NAME = "Qwerty";
    private static final String FINDING_PATTERN = "qwerty";

    private StudentDatabase database;
    private StudentRepository repository;

    @Before
    public void init() {
        Context context = App.getInstance().getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, StudentDatabase.class).build();
        repository = database.studentRepository();
    }

    @Test
    public void testDoesStudentInsertAndFindBySurnameMatches() {
        Student student = new Student();
        student.setSurname(SURNAME);
        student.setName(NAME);

        repository.insert(student);
        List<Student> students = repository.getBySurnameLike(FINDING_PATTERN);

        assertEquals(student, students.get(0));
    }

    @After
    public void destroy() {
        database.close();
    }
}
