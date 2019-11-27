package com.example.bemine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Boolean signUpModeActive = true;
    TextView loginTextView;


    @Override

    public void onClick(View view) {
        if(view.getId() == R.id.loginTextView){
            Button signUpButton = findViewById(R.id.signUpButton);
            if(signUpModeActive){
                signUpModeActive = false;
                signUpButton.setText("LOGIN");
                loginTextView.setText("Do not have an account ? Sign up");

            }else{
                signUpModeActive = true;
                signUpButton.setText("SIGN UP");
                loginTextView.setText("Already have an account ? Login");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tx = findViewById(R.id.textView);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/clickerscript-regular.ttf");

        tx.setTypeface(custom_font);
        loginTextView = findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(this);
        

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
    public void signUpClicked(View view){
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        if (usernameEditText.getText().toString() == "" && passwordEditText.getText().toString() == ""){
            Toast.makeText(this,"A username and a password are required",Toast.LENGTH_LONG).show();
        }else {
            if(signUpModeActive) {
                ParseUser user = new ParseUser();
                user.setUsername(usernameEditText.getText().toString());
                user.setPassword(usernameEditText.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.i("Sign up", "Success");
                            Toast.makeText(MainActivity.this,"Sign up success",Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else{
                //Login
                ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null){
                            Log.i("Login", "success");
                            Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }

}
