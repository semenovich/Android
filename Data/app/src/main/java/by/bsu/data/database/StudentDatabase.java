package by.bsu.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import by.bsu.data.entity.Student;
import by.bsu.data.repository.StudentRepository;

@Database(entities = {Student.class}, version = 2, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentRepository studentRepository();

}
