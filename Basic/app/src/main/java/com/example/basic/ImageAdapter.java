package com.example.basic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

//import android.view.ViewHolder;

public class ImageAdapter extends  RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    public ArrayList<Cell> galleryList;
    private Context context;

    public ImageAdapter(Context context, ArrayList<Cell> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ImageAdapter.ViewHolder viewHolder, final int i) {
        //viewHolder.title.setText(galleryList.get(i).getTitle());
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.img.setImageResource(galleryList.get(i).getImg());

        //ImageView imageview = (ImageView) findViewById(R.id.imageView);

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView imageview = (ImageView) view.findViewById(R.id.fullScreenimageView);
                Intent fullScreenIntent = new Intent(view.getContext(), FullScreenImageActivity.class);
                fullScreenIntent.putExtra("picture", i);
                viewHolder.img.getContext().startActivity(fullScreenIntent);


            }
        });


    }


    public int getItemCount() {
        return galleryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }


}
