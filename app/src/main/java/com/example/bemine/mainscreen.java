package com.example.bemine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class mainscreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    ConstraintLayout dateLayout;
    ConstraintLayout mainLayout;
    TextView textView;
    DatePicker simpleDatePicker;
    Button submitButton;
    TextView dayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        textView = findViewById(R.id.textView);
        dayTextView = findViewById(R.id.dayTextView);
        simpleDatePicker = findViewById(R.id.simpleDatePicker);
        submitButton = findViewById(R.id.submitButton);
        dateLayout = findViewById(R.id.dateLayout);
        mainLayout = findViewById(R.id.mainLayout);

        submitButton.setVisibility(View.VISIBLE);
        simpleDatePicker.setVisibility(View.VISIBLE);
        mainLayout.setVisibility(View.INVISIBLE);



    }

    public void mainLayout (View view){
        submitButton.setVisibility(View.INVISIBLE);
        mainLayout.setVisibility(View.VISIBLE);
    }
    public void getDay(View view){

    }
}
