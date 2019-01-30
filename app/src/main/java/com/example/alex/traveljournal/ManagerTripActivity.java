package com.example.alex.traveljournal;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ManagerTripActivity extends AppCompatActivity {
    private SeekBar mSeekBar;
    private TextView mTextView;
    private RatingBar mRatingBar;
    private EditText mTripName;
    private EditText mDestination;
    private static final String TRIP_NAME = "trip";
    private static final String DESTINATION = "destination";
    private static final String SEEK = "seek";
    private static final String RATING = "rating";

    public static HomeFragment my_fragment = new HomeFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_trip);
        initView();
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
                Bundle bundle = new Bundle();
                bundle.putString(TRIP_NAME, nume_trip);
                bundle.putString(DESTINATION, destinatie);
                bundle.putDouble(RATING, rating);
                bundle.putInt(SEEK, seekbar);
                my_fragment.setArguments(bundle);
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
}
