package com.example.bemine;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User data);

    @Query("SELECT Password FROM User WHERE Username LIKE :username")
    String getPassword ( String username);

    @Query("SELECT Username FROM User")
   String getUsername ();
}
