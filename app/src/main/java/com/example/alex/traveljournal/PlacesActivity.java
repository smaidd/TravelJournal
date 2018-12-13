package com.example.alex.traveljournal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlacesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_activity);
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        PlacesAdapter placesAdapter = new PlacesAdapter(getPlaces());
        mRecyclerView.setAdapter(placesAdapter);

    }

    private List<Places> getPlaces() {
        List<Places> placesList = new ArrayList<>();
        placesList.add(new Places("Summer 2012", "Rome", "http://i.imgur.com/DvpvklR.png"));
        placesList.add(new Places("Winter 2012", "Netherland", "https://www.google.ro/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjyh-CQypffAhVKJ1AKHZd8AdkQjRx6BAgBEAU&url=https%3A%2F%2Fwww.fodors.com%2Fworld%2Feurope%2Fitaly%2Frome%2Fexperiences%2Fnews%2Fphotos%2F25-ultimate-things-to-do-in-rome&psig=AOvVaw3sVGTFgX6QFQsDmX9pOurA&ust=1544610890518174"));
        placesList.add(new Places("LateSummer 2012", "Rome", "http://i.imgur.com/DvpvklR.png"));
        placesList.add(new Places("Summer 2012", "Paris", "http://i.imgur.com/DvpvklR.png"));
        placesList.add(new Places("Summer 2012", "Rome", "http://i.imgur.com/DvpvklR.png"));
        return placesList;
    }
}
