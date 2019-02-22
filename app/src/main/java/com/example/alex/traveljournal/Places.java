package com.example.alex.traveljournal;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class Places {
    @SerializedName("location")
    private String mLocation;

    @SerializedName("trip")
    private String mTripName;

    @SerializedName("image")
    private String mImage;

    @SerializedName("rating")
    private double mRating;

    @SerializedName("price")
    private int mSeek;

    @SerializedName("Bitmap")
    private Bitmap bitmap;

    public Places(String mLocation, String mTripName, String mImage, double mRating, int mSeek) {
        this.mLocation = mLocation;
        this.mTripName = mTripName;
        this.mImage = mImage;
        this.mRating = mRating;
        this.mSeek = mSeek;
    }

    public Places(String mLocation, String mTripName, double mRating, int mSeek, Bitmap bitmap) {
        this.mLocation = mLocation;
        this.mTripName = mTripName;
        this.mRating = mRating;
        this.mSeek = mSeek;
        this.bitmap = bitmap;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmTripName() {
        return mTripName;
    }

    public void setmTripName(String mTripName) {
        this.mTripName = mTripName;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public double getmRating() {
        return mRating;
    }

    public void setmRating(double mRating) {
        this.mRating = mRating;
    }

    public int getmSeek() {
        return mSeek;
    }

    public void setmSeek(int mSeek) {
        this.mSeek = mSeek;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}