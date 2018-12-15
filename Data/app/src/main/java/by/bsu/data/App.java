package by.bsu.data;

import android.app.Application;
import android.arch.persistence.room.Room;

import by.bsu.data.database.StudentDatabase;

public class App extends Application {

    private static final String DATABASE_NAME = "database";

    public static App instance;

    private StudentDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, StudentDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public StudentDatabase getDatabase() {
        return database;
    }
}
