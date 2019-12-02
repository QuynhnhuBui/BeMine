package com.example.bemine;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;

public class UserViewModel extends AndroidViewModel {
    private UserRepository mRepository;
    public UserViewModel (Application application) {
        super(application);
        mRepository = new UserRepository(application);
    }
    public void insert(User data){mRepository.insert(data);}

    public String getPassword (String username ) {

        return mRepository.getPassword(username);
    }
}
