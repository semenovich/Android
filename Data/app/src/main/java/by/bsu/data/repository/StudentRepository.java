package by.bsu.data.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import by.bsu.data.entity.Student;

@Dao
public interface StudentRepository {

    @Insert
    void insert(Student student);

    @Query("SELECT * FROM student s WHERE instr(UPPER(surname), UPPER(:surname))")
    List<Student> getBySurnameLike(String surname);
}
