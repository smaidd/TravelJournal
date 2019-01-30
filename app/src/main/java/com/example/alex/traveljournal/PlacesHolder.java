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
    private TextView mRating;

    public PlacesHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView_place);
        mUpperText = itemView.findViewById(R.id.period);
        mBottomText = itemView.findViewById(R.id.place_to_go);
        mRating = itemView.findViewById(R.id.rating_price);
    }

    public TextView getmRating() {
        return mRating;
    }

    public void setmRating(TextView mRating) {
        this.mRating = mRating;
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
