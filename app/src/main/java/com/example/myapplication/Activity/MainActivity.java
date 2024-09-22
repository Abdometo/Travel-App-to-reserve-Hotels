package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.myapplication.Adapter.ItemsAdapter;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.domain.PropertyDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Binding
    ActivityMainBinding activityMainBinding;
    // Adapter
    private RecyclerView.Adapter adapterRecommended,adapterNearby;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        
        initLocation();
        initList();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

    private void initList() {
        // Create an Array List for Recommended Properties
        ArrayList<PropertyDomain> items = new ArrayList<>();
        items.add(new PropertyDomain("Apartment","Royal Apartment","Los Angles,LA","house_1",1500,2,3,350,true,4.5,"Welcome to this charming 2-bedroom apartment, a perfect blend of modern comfort and convenience. Situated in a desirable neighborhood "));
        items.add(new PropertyDomain("Apartment","House with great view","New York,NY","house_2",800,1,2,500,false,4.9,"Welcome to this charming 2-bedroom apartment, a perfect blend of modern comfort and convenience. Situated in a desirable neighborhood "));
        items.add(new PropertyDomain("Apartment","Royal Villa","Los Angles,LA","house_3",999,2,1,400,true,4.7,"Welcome to this charming 2-bedroom apartment, a perfect blend of modern comfort and convenience. Situated in a desirable neighborhood"));
        items.add(new PropertyDomain("Apartment","beauty house","New York,NY","house_4",1750,3,2,1100,true,4.3,"Welcome to this charming 2-bedroom apartment, a perfect blend of modern comfort and convenience. Situated in a desirable neighborhood"));
        activityMainBinding.recommendedRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        activityMainBinding.recommendedRecyclerView.setAdapter(new ItemsAdapter(items));

        // Create an Array List for Nearby Properties
        ArrayList<PropertyDomain> itemsNearBy = new ArrayList<>();
        itemsNearBy.add(new PropertyDomain("House","Beauty House","Los Angles,LA","house_1",1500,2,3,350,true,4.5,"this is "));
        itemsNearBy.add(new PropertyDomain("Villa","Royal Villa","New York,NY","house_2",800,1,2,500,false,4.9,"This is "));
        itemsNearBy.add(new PropertyDomain("House","House With Great View","Los Angles,LA","house_3",999,2,1,400,true,4.7,"This is 2 bed"));
        itemsNearBy.add(new PropertyDomain("Apartment","Royal Apartment","New York,NY","house_4",1750,3,2,1100,true,4.3,"This is "));
        activityMainBinding.nearbyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        activityMainBinding.nearbyRecyclerView.setAdapter(new ItemsAdapter(itemsNearBy));
    }

    private void initLocation() {

        // create a list of Locations
        String[] items = new String[]{"Los Angles , USA","New York,USA"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activityMainBinding.locationSpinner.setAdapter(adapter);

    }
}