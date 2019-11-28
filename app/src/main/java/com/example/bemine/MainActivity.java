package com.example.bemine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Boolean signUpModeActive = true;
    TextView loginTextView;
    private UserViewModel userViewModel;


    @Override

    public void onClick(View view) {
        if (view.getId() == R.id.loginTextView) {
            Button signUpButton = findViewById(R.id.signUpButton);
            if (signUpModeActive) {
                signUpModeActive = false;
                signUpButton.setText("LOGIN");
                loginTextView.setText("Do not have an account ? Sign up");

            } else {
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
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/clickerscript-regular.ttf");
        tx.setTypeface(custom_font);
        loginTextView = findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(this);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    public void signUpClicked(View view) {
        final EditText usernameEditText = findViewById(R.id.usernameEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);
        if (signUpModeActive) {
            if (usernameEditText.getText().toString() == "" && passwordEditText.getText().toString() == "") {
                Toast.makeText(this, "A username and a password are required", Toast.LENGTH_LONG).show();
            } else {
                User user = new User();
                user.setmPassword(passwordEditText.getText().toString());
                user.setmUsername(usernameEditText.getText().toString());
                userViewModel.insert(user);
            }
        }
        else {
            if (usernameEditText.getText().toString() == "" && passwordEditText.getText().toString() == "") {
                Toast.makeText(this, "A username and a password are required", Toast.LENGTH_LONG).show();
            } else {
                Log.d("LongLe", "password " + passwordEditText.getText().toString());
                Log.d("LongLe", "check " + userViewModel.getPassword(usernameEditText.getText().toString()));
               boolean alo = userViewModel.getPassword(usernameEditText.getText().toString()).equals(passwordEditText.getText().toString());
               if (alo) {
                   Toast.makeText(this, "OK ban", Toast.LENGTH_SHORT).show();
               }
            }
        }
    }

}
