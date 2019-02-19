package com.example.alex.traveljournal;

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

    public Places(String location, String trip, String image, double rating, int price) {
        this.mLocation = location;
        this.mTripName = trip;
        this.mImage = image;
        this.mRating = rating;
        this.mSeek = price;
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
}