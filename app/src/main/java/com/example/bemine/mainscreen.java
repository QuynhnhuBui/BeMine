package com.example.bemine;

import androidx.annotation.Nullable;
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
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class mainscreen extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        sharedPreferences = this.getSharedPreferences("com.example.bemine",Context.MODE_PRIVATE);
        String startDay = sharedPreferences.getString("startDay","Error");
        Log.d("Nhu", startDay);
        if(startDay.equals("Error")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(mainscreen.this);
            View mView = getLayoutInflater().inflate(R.layout.diaalog_day, null);
            EditText mDay = mView.findViewById(R.id.dayEditText);
            Button mSubmit = mView.findViewById(R.id.button);
            mSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String startDay = mDay.getText().toString();
                    sharedPreferences.edit().putString("starDay",startDay).apply();
                }
            });
            mBuilder.setView(mView);
            AlertDialog alertDialog = mBuilder.create();
            alertDialog.show();
        }
    }


    public void getDay(String startDay){

    }
}
