package com.example.coreinsta.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coreinsta.Interface.PostInterface;
import com.example.coreinsta.ModulClass.Post;
import com.musict.coreinstagram.R;

import java.util.ArrayList;

public class inpost extends RecyclerView.Adapter<inpost.Viewholder> {
    ArrayList<Post> postdata;
    Context context;

    PostInterface postInterface;

    public inpost(ArrayList<Post> postdata, PostInterface postInterface) {
        this.postdata = postdata;
        this.postInterface=postInterface;

    }

    @NonNull
    @Override
    public inpost.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postitem,parent,false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull inpost.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.postimg.setImageResource(postdata.get(position).getPostaccimg());
        holder.txtpostname.setText(postdata.get(position).getPostname());
        holder.imgpostphoto.setImageResource(postdata.get(position).getPostimg());

        holder.loutvertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postInterface.clickedon(postdata.get(position).getPostaccimg(),postdata.get(position).getPostname(),postdata.get(position).getPostimg());
            }
        });
    }

    @Override
    public int getItemCount() {
        return postdata.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView postimg;
        TextView txtpostname;
        ImageView imgpostphoto;
        LinearLayout loutvertical;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            postimg = itemView.findViewById(R.id.postimg);
            txtpostname = itemView.findViewById(R.id.txtpostname);
            imgpostphoto = itemView.findViewById(R.id.imgpostphoto);
            loutvertical = itemView.findViewById(R.id.loutvertical);
        }
    }
}
