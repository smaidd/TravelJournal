package com.example.alex.traveljournal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter <PlacesHolder> {
    private List<Places> places;

    public PlacesAdapter(List<Places> places) {
        this.places = places;
    }

    @NonNull
    @Override
    public PlacesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutInflater = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.places_item,viewGroup,false);
        return new PlacesHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesHolder placesHolder, int i) {
        Places placesss = places.get(i);
        placesHolder.getmUpperText().setText(placesss.getmUpperName());
        placesHolder.getmBottomText().setText(placesss.getmBottomName());

        Picasso.get().load(placesss.getmImage()).fit().centerCrop()
                .into(placesHolder.getmImageView());
    }

    @Override
    public int getItemCount() {
      return  places.size();
    }
}
