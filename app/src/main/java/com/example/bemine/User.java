package com.example.bemine;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    public int mId;

    @ColumnInfo(name = "Username")
    public String mUsername;

    @ColumnInfo(name = "Password")
    public String mPassword;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }
    public String getmPassword(){
        return mPassword;
    }
    public void setmPassword(String mPassword){
        this.mPassword = mPassword;
    }

}
