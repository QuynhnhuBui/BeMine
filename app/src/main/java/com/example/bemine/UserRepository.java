package com.example.bemine;

import android.app.Application;
import android.content.Context;
import android.util.Log;


import androidx.room.Room;

import com.example.bemine.AppDatabase;


public class UserRepository {
    private UserDAO userDAO;

    public UserRepository(Application application) {
        AppDatabase appDatabase = Room.databaseBuilder(application,AppDatabase.class,"db_task").allowMainThreadQueries().build();
        userDAO = appDatabase.userDAO();
    }

    public String getPassword(String username) {
        Log.d("LongLe",userDAO.getPassword(username));
        return userDAO.getPassword(username);
    }

    public void insert(User data) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDAO.insertUser(data);
        });
    }

    public String getUsername() {
        final String[] username = new String[1];
        AppDatabase.databaseWriteExecutor.execute(() -> {
            username[0] = userDAO.getUsername();
        });
        return username[0];
    }
}
