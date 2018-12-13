package com.example.alex.traveljournal;

public class Places {
    private String mUpperName;
    private String mBottomName;
    private String mImage;

    public Places(String mUpperName, String mBottomName, String mImage) {
        this.mUpperName = mUpperName;
        this.mBottomName = mBottomName;
        this.mImage = mImage;
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
}
