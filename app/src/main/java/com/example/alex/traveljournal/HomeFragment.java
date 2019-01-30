package com.example.alex.traveljournal;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private String trip_name;
    Bundle bundle;
    private String destination;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view_trips_wowow);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        Log.d("debugMode", "The application stopped after this");
        try {
            PlacesAdapter placesAdapter = new PlacesAdapter(getPlaces());
            mRecyclerView.setAdapter(placesAdapter);
            return view;
        }catch (EmptyListException o){
            Toast.makeText(this.getActivity(), "Empty list", Toast.LENGTH_SHORT).show();
        }
        return  null;

    }



    private List<Places> getPlaces() {
        List<Places> placesListTrips = new ArrayList<>();
        Bundle bundle = getArguments();
        if (bundle != null) {
            String trip_name = bundle.getString(ManagerTripActivity.getTripName());
            String destination = bundle.getString(ManagerTripActivity.getDESTINATION());
            double rating = bundle.getDouble(ManagerTripActivity.getRATING());
            int seek = bundle.getInt(ManagerTripActivity.getSEEK());
            placesListTrips.add(new Places(trip_name, destination, "https://aventurescu.ro/wp-content/uploads/2018/07/Roma-aventurescu-3.jpg",rating,seek));
        }
        if(placesListTrips.isEmpty()){
            throw new EmptyListException();
        }
        return placesListTrips;


    }

}