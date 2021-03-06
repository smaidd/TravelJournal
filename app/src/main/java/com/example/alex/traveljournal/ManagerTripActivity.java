package com.example.alex.traveljournal;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ManagerTripActivity extends AppCompatActivity {

    private SeekBar mSeekBar;
    private TextView mTextView;
    private RatingBar mRatingBar;
    private EditText mTripName;
    private EditText mDestination;

    public String url;


    private static final String TRIP_NAME = "trip";
    private static final String DESTINATION = "destination";
    private static final String SEEK = "seek";
    private static final String RATING = "rating";
    private static final int REQ_CODE_CAMERA = 1;
    private static final int REQ_OPEN_GALERY = 144;
    private FirebaseFirestore mFireStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_trip);
        initView();
        initFireStore();
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextView.setText("Price(euro) " + "( " + progress + " €)");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void initView() {
        mSeekBar = findViewById(R.id.seek_bar);
        mTextView = findViewById(R.id.text_view_price);
        mTripName = findViewById(R.id.trip_name);
        mDestination = findViewById(R.id.destination);
        mRatingBar = findViewById(R.id.rating_bar);
    }

    private void initFireStore() {
        mFireStore = FirebaseFirestore.getInstance();
    }


    public static String getTripName() {
        return TRIP_NAME;
    }

    public static String getDESTINATION() {
        return DESTINATION;
    }

    public static String getSEEK() {
        return SEEK;
    }

    public static String getRATING() {
        return RATING;
    }

    public void btnSaveTravel(View view) {

        if (mTripName != null && mDestination != null) {
            String nume_trip = mTripName.getText().toString();
            String destinatie = mDestination.getText().toString();
            double rating = mRatingBar.getRating();
            int seekbar = mSeekBar.getProgress();
            if (!nume_trip.isEmpty() && !destinatie.isEmpty()) {

                Intent intent = new Intent(this, Drawer.class);



                Places places = new Places(nume_trip, destinatie, url, rating, seekbar);
                

                mFireStore.collection("TRIPS").document(nume_trip).set(places).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ManagerTripActivity.this, "Added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ManagerTripActivity.this, "Faild", Toast.LENGTH_SHORT).show();
                    }
                });


                startActivity(intent);

                System.out.println("A mers");
            } else {
                Toast.makeText(this, "Please fill the fields", Toast.LENGTH_LONG).show();
            }
        }


    }


    public void onStartDateClick(View view) {
        DatePicker datePicker = new DatePicker();
        datePicker.show(getSupportFragmentManager(), "StartDate");

    }

    public void onEndDateCLick(View view) {
        DatePicker datePicker = new DatePicker();
        datePicker.show(getSupportFragmentManager(), "EndDate");
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void btnStartCamera(View view) {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    REQ_CODE_CAMERA);
        } else {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQ_CODE_CAMERA);
            }
        }
    }


    public void btnOpenGalery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


        intent.setType("image/*");

        startActivityForResult(intent.createChooser(intent, "Select"), REQ_OPEN_GALERY);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_OPEN_GALERY) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                try {
                    InputStream inputStream = getContentResolver().openInputStream(uri);
                    Bitmap recivedImage = BitmapFactory.decodeStream(inputStream);
                    BitMapToString(recivedImage);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                finishActivity(REQ_CODE_CAMERA);
            }
        }
        if (requestCode == REQ_CODE_CAMERA) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imagebitmap = (Bitmap) extras.get("data");
                BitMapToString(imagebitmap);
            }
            if (resultCode == RESULT_CANCELED) {
                finishActivity(REQ_OPEN_GALERY);
            }
        }
    }

    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        url = Base64.encodeToString(b, Base64.DEFAULT);
        return url;
    }

    public String getUrl() {
        return url;
    }
}


