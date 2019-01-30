package com.example.alex.traveljournal;

public class Places {
    private String mUpperName;
    private String mBottomName;
    private String mImage;
    private double mRating;
    private int mSeek;

    public Places(String mUpperName, String mBottomName, String mImage, double mRating, int mSeek) {
        this.mUpperName = mUpperName;
        this.mBottomName = mBottomName;
        this.mImage = mImage;
        this.mRating = mRating;
        this.mSeek = mSeek;
    }

    public String getmUpperName() {
        return mUpperName;
    }

    public void setmUpperName(String mUpperName) {
        this.mUpperName = mUpperName;
    }

    public String getmBottomName() {
        return mBottomName;
    }

    public void setmBottomName(String mBottomName) {
        this.mBottomName = mBottomName;
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