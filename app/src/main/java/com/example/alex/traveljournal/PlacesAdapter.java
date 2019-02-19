package com.example.alex.traveljournal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesHolder> {
    private List<Places> places;

    public PlacesAdapter(List<Places> places) {
        this.places = places;
    }

    @NonNull
    @Override
    public PlacesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutInflater = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.places_item, viewGroup, false);
        return new PlacesHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesHolder placesHolder, int i) {

        if (places != null) {
            Places placesss = places.get(i);
            placesHolder.getmUpperText().setText(placesss.getmTripName());
            placesHolder.getmBottomText().setText(placesss.getmLocation());
            placesHolder.getmRating().setText("Rating: " + placesss.getmRating() + " stars" + '\n' + "Price: " + placesss.getmSeek() + " euro");
            Glide.with(placesHolder.itemView).load(placesss.getmImage()).into(placesHolder.getmImageView());
        } else {
            throw new EmptyListException();
        }

    }


    @Override
    public int getItemCount() {
        return places.size();
    }
}