package com.example.myapplication.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.DetailsActivity;
import com.example.myapplication.databinding.ViewholderItemBinding;
import com.example.myapplication.domain.PropertyDomain;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    // Attributes
    ArrayList<PropertyDomain> items;
    Context context;
    ViewholderItemBinding binding;

    // constructor


    public ItemsAdapter(ArrayList<PropertyDomain> items) {
        this.items = items;
    }

    // View Holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(ViewholderItemBinding binding) {
            super(binding.getRoot());
        }
    }

    // Implement Methods

    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context = parent.getContext();
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        binding.titleText.setText(items.get(position).getTitle());
        binding.priceText.setText("$"+items.get(position).getPrice());
        binding.typeText.setText(items.get(position).getType());
        binding.addressText.setText(items.get(position).getAddress());
        binding.scoreText.setText(""+items.get(position).getScore());
        binding.bedText.setText(""+items.get(position).getBed());
        binding.bathText.setText(""+items.get(position).getBath());

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());

        // Glide Library
        Glide
                .with(context)
                .load(drawableResourceId)
                .into(binding.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("object",items.get(position));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
