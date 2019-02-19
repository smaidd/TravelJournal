package com.example.alex.traveljournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFAB;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private FrameLayout mainContainer;
    private List<Places> places_locations = new ArrayList<>();
    private GoogleSignInClient googleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);


        initView();


        setSupportActionBar(mToolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        mNavigationView.setNavigationItemSelectedListener(this);

    }

    private void initView() {

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFAB = findViewById(R.id.fab);
        mToolbar = findViewById(R.id.toolbar);
        mainContainer = findViewById(R.id.main_container);
        mNavigationView = findViewById(R.id.nav_view);


    }

    private void initFragment(HomeFragment homeFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, homeFragment);
        fragmentTransaction.commit();
    }


    public void btnAddNewTravel(View view) {
        Intent intent = new Intent(this, ManagerTripActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        HomeFragment h = new HomeFragment();
        int id = item.getItemId();

        if (id == R.id.home_drawer) {
            if (h.isAdded()) {
                mDrawerLayout.closeDrawers();
                return false;
            } else {
                initFragment(h);
            }


        } else if (id == R.id.favourite_drawer)

        {


        } else if (id == R.id.about_us)

        {
            Toast.makeText(this, "You chose bout us", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.contact_drawer)

        {
            Toast.makeText(this, "You chose contact us", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share)

        {

        } else if (id == R.id.nav_send)

        {

        }


        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
