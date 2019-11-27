package com.example.bemine;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ParseApplication extends Application {
    public void onCreate() {
        super.onCreate();

        //password : AKDzERPAPkN2

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("ce5200746542487fc3616d2e48650675eb6c6d3b")
                .clientKey("7df0250c76ecb3b38611eb40e4ee2eb60e79535c")
                .server("http://18.188.209.120:80/parse/")
                .build()
        );

        //ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
