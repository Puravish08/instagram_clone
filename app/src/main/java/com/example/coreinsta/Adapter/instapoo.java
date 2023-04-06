package com.example.coreinsta.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coreinsta.Interface.StoryInterface;
import com.example.coreinsta.ModulClass.User;
import com.musict.coreinstagram.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class instapoo extends RecyclerView.Adapter<instapoo.MyViewHolder> {
    ArrayList<User> data;
    StoryInterface storyInterface;
    Context context;


    public instapoo(ArrayList<User> data, StoryInterface storyInterface) {
        this.data = data;
        this.storyInterface = storyInterface;

    }

    @NonNull
    @Override
    public instapoo.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.storyitem, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull instapoo.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cirstoryimg.setImageResource(data.get(position).getProfileimage());
        holder.txtstory.setText(data.get(position).getProfilename());

        holder.louthorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storyInterface.onclick(data.get(position).getProfileimage(), data.get(position).getProfilename(), data.get(position).getProfilebigimg());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView cirstoryimg;
        TextView txtstory;


        LinearLayout louthorizontal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cirstoryimg = itemView.findViewById(R.id.cirstoryimg);
            txtstory = itemView.findViewById(R.id.txtstory);
            louthorizontal = itemView.findViewById(R.id.louthorizontal);
        }
    }


}
