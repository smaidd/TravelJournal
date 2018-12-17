package com.example.alex.traveljournal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlacesHolder extends RecyclerView.ViewHolder {
    private ImageView mImageView;
    private TextView mUpperText;
    private TextView mBottomText;

    public PlacesHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView);
        mUpperText = itemView.findViewById(R.id.textView);
        mBottomText = itemView.findViewById(R.id.textView2);
    }

    public ImageView getmImageView() {
        return mImageView;
    }

    public void setmImageView(ImageView mImageView) {
        this.mImageView = mImageView;
    }

    public TextView getmUpperText() {
        return mUpperText;
    }

    public void setmUpperText(TextView mUpperText) {
        this.mUpperText = mUpperText;
    }

    public TextView getmBottomText() {
        return mBottomText;
    }

    public void setmBottomText(TextView mBottomText) {
        this.mBottomText = mBottomText;
    }
}
