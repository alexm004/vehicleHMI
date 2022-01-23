package com.example.vehiclehmi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRowAdapter extends RecyclerView.Adapter<CustomRowAdapter.ViewHolder> {

    private String[] arrItems1 = {"HL Brightness ON","HL Brightness OFF"};

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textview1;
        public ImageButton imageButton1;
        public ImageButton imageButton2;
        public TextView textview2;


        public ViewHolder(@NonNull View v2) {
            super(v2);
            textview1=v2.findViewById(R.id.HL_brightness);
            imageButton1=v2.findViewById(R.id.imageButton1);
            imageButton2=v2.findViewById(R.id.imageButton2);
            textview2=v2.findViewById(R.id.textView2);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v2= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_second,parent,false);
        ViewHolder vh=new ViewHolder(v2);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textview1.setText(arrItems1[position]);


    }

    @Override
    public int getItemCount() {
        return arrItems1.length;
    }

}

