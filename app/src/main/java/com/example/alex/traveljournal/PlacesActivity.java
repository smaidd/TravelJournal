//package com.example.alex.traveljournal;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.design.widget.NavigationView;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.MenuItem;
//import android.view.View;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PlacesActivity extends AppCompatActivity {
//    private RecyclerView mRecyclerView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.places_activity);
//        initView();
//    }
//
//    private void initView() {
//        mRecyclerView = findViewById(R.id.recycler_view);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(layoutManager);
//
//        PlacesAdapter placesAdapter = new PlacesAdapter(getPlaces());
//        mRecyclerView.setAdapter(placesAdapter);
//
//    }
//
//    private List<Places> getPlaces() {
//        List<Places> placesList = new ArrayList<>();
//        placesList.add(new Places("Summer 2012", "Rome", "https://cdn.fodors.com/wp-content/uploads/2018/10/HERO_UltimateRome_Hero_shutterstock789412159.jpg"));
//        placesList.add(new Places("LateSummer 2012", "Rome", "https://www.timeshighereducation.com/sites/default/files/styles/the_breaking_news_image_style/public/ancient-rome.jpg?itok=tGe7MzMU"));
//        placesList.add(new Places("Summer 2012", "Paris", "https://photos.mandarinoriental.com/is/image/MandarinOriental/paris-2017-home?wid=2880&hei=1280&fmt=jpeg&crop=9,336,2699,1200&anchor=1358,936&qlt=75,0&fit=wrap&op_sharpen=0&resMode=sharp2&op_usm=0,0,0,0&iccEmbed=0&printRes=72"));
//        placesList.add(new Places("Winter 2012", "Netherland","https://travelpassionate.com/wp-content/uploads/2018/05/Landscape-with-tulips-traditional-dutch-windmills-and-houses-near-the-canal-in-Zaanse-Schans-Netherlands-Europe-min.jpg"));
//        placesList.add(new Places("Summer 2012", "Rome", "https://media.parkimeter.com/images/blog/high/parking-for-free-in-rome-21d09c78db3e556a4929af34f7d96b58.jpg"));
//        return placesList;
//    }
//
//}
