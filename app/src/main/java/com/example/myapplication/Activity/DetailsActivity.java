package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityDetailsBinding;
import com.example.myapplication.domain.PropertyDomain;

public class DetailsActivity extends AppCompatActivity {
    // Binding
    ActivityDetailsBinding activityDetailsBinding;

    private PropertyDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailsBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(activityDetailsBinding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);



        getBundles();
        setVariable();
    }

    private void setVariable() {
        activityDetailsBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int drawableResourceId= getResources().getIdentifier(object.getPicPath(),"drawable",DetailsActivity.this.getPackageName());

        Glide
                .with(DetailsActivity.this)
                .load(drawableResourceId)
                .into(activityDetailsBinding.picDetails);

        activityDetailsBinding.titleAddressText.setText(object.getTitle()+" in "+object.getAddress());
        activityDetailsBinding.typeText.setText(object.getType());
        activityDetailsBinding.descriptionText.setText(object.getDescription());
        activityDetailsBinding.priceText.setText("$"+object.getPrice());
        activityDetailsBinding.bedText.setText(object.getBed()+" Bedroom");
        activityDetailsBinding.bathText.setText(object.getBath()+" Bathroom");
        activityDetailsBinding.sizeText.setText(object.getSize()+" m2");

        if(object.isGarage()){
            activityDetailsBinding.garageText.setText("Car Garage");
        }else{
            activityDetailsBinding.garageText.setText("No Car Garage");
        }

    }

    private void getBundles() {
        object = (PropertyDomain) getIntent().getSerializableExtra("object");
    }
}