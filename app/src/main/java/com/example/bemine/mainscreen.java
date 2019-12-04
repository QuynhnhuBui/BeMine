package com.example.bemine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class mainscreen extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sharedPreferences;
    TextView dayTextView;
    int SELECT_PICTURE1 = 100;
    int SELECT_PICTURE2 = 101;
    ImageView imageView;
    ImageView imageView1;
    Date currentDate;
    Date startDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        imageView = findViewById(R.id.imageView2);
        imageView1 = findViewById(R.id.imageView5);
        dayTextView = findViewById(R.id.dayTextView);
        sharedPreferences = this.getSharedPreferences("com.example.bemine", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
        String startDay = sharedPreferences.getString("startDay", "Error");
        if (startDay.equals("Error")) {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(mainscreen.this);
            View mView = getLayoutInflater().inflate(R.layout.diaalog_day, null);
            EditText mDay = mView.findViewById(R.id.dayEditText);
            mBuilder.setView(mView);
            mBuilder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String startDay = mDay.getText().toString();
                    sharedPreferences.edit().putString("startDay", startDay).apply();
                }
            });
            AlertDialog alertDialog = mBuilder.create();
            alertDialog.show();

        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String endDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

        try {

            Log.d("Nhu", endDate);
            currentDate = simpleDateFormat.parse(endDate);
            startDate = simpleDateFormat.parse(startDay);

        } catch (Exception e) {
            e.printStackTrace();
        }

        imageView.setOnClickListener(this);
        imageView1.setOnClickListener(this);

        TextView tx = findViewById(R.id.textView);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/clickerscript-regular.ttf");
        tx.setTypeface(custom_font);
        Typeface custom= Typeface.createFromAsset(getAssets(), "font/crimsonpro-extraLight.ttf");
        dayTextView.setTypeface(custom);
        dayDifference(startDate,currentDate);


    }


    public void dayDifference(Date startDay, Date endDay) {
        long different = endDay.getTime() - startDay.getTime();
        long differenceDates = different / (24 * 60 * 60 * 1000);
        dayTextView.setText(String.format("%d",differenceDates) + "\n days" );
        Log.d("Nhu",String.valueOf(differenceDates));

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageView2) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE1);
        }
        if (v.getId() == R.id.imageView5) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE2);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE1) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    String path = selectedImageUri.getPath();
                    Log.e("image path", path + "");

                    imageView.setImageURI(selectedImageUri);
                }
            }
        }
        if (requestCode == SELECT_PICTURE2) {
            Uri selectedImageUri = data.getData();
            if (null != selectedImageUri) {
                String path = selectedImageUri.getPath();
                Log.e("image path", path + "");
                imageView1.setImageURI(selectedImageUri);
            }
        }

    }
}

