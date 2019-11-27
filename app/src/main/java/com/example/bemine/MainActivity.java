package com.example.bemine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tx = (TextView)findViewById(R.id.textView);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/clickerscript-regular.ttf");

        tx.setTypeface(custom_font);


        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
    public void signUpClicked(View view){
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        if (usernameEditText.getText().toString() == "" && passwordEditText.getText().toString() == ""){
            Toast.makeText(this,"A username and a password are required",Toast.LENGTH_LONG).show();
        }else {
            ParseUser user = new ParseUser();
            user.setUsername(usernameEditText.getText().toString());
            user.setPassword(usernameEditText.getText().toString());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){
                        Log.i("Sign up", "Success");
                    }else {
                        Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
