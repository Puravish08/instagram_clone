package com.example.coreinsta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coreinsta.Adapter.inpost;
import com.example.coreinsta.Adapter.instapoo;
import com.example.coreinsta.Interface.PostInterface;
import com.example.coreinsta.Interface.StoryInterface;
import com.example.coreinsta.ModulClass.Post;
import com.example.coreinsta.ModulClass.User;
import com.example.coreinsta.item.Position;
import com.example.coreinsta.item.Positionstory;
import com.musict.coreinstagram.R;
//import com.musict.coreinstagram.R;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //    story id
    ArrayList<Integer> proimg = new ArrayList<>();
    ArrayList<String> proname = new ArrayList<>();
    ArrayList<User> data = new ArrayList<User>();
    RecyclerView rcvmain;
    ArrayList<Integer> sdimg = new ArrayList<>();

    //   post id
    ArrayList<Integer> postaccimg = new ArrayList<>();
    ArrayList<String> postname = new ArrayList<>();
    ArrayList<Integer> postimg = new ArrayList<>();
    ArrayList<Post> postdata = new ArrayList<Post>();
    RecyclerView rcvpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        postview();

    }

    private void postview() {
        postdetails();

        PostInterface postInterface = new PostInterface() {
            @Override
            public void clickedon(int postphoto, String postname, int postaccphoto) {
                Intent o = new Intent(MainActivity.this, Position.class);
                o.putExtra("photos",postphoto);
                o.putExtra("names",postname);
                o.putExtra("accphoto",postaccphoto);
                startActivity(o);
            }
        };

        for (int i = 0; i < 9; i++) {
            Post model = new Post();
            model.setPostaccimg(postaccimg.get(i));
            model.setPostimg(postimg.get(i));
            model.setPostname(postname.get(i));
            postdata.add(model);

            rcvpost = findViewById(R.id.rcvpost);
            inpost postAdapter = new inpost(postdata,postInterface);

            LinearLayoutManager postmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rcvpost.setLayoutManager(postmanager);
            rcvpost.setAdapter(postAdapter);


        }
    }

    private void postdetails() {
        postname.add("Roman");
        postname.add("royal");
        postname.add("kings");
        postname.add("devil");
        postname.add("antim");
        postname.add("lions");
        postname.add("herom");
        postname.add("local");
        postname.add("riche");
        postname.add("newbe");

        postaccimg.add(R.drawable.ph6);
        postaccimg.add(R.drawable.ph1);
        postaccimg.add(R.drawable.p2);
        postaccimg.add(R.drawable.ph3);
        postaccimg.add(R.drawable.ph4);
        postaccimg.add(R.drawable.ph5);
        postaccimg.add(R.drawable.ph7);
        postaccimg.add(R.drawable.ph8);
        postaccimg.add(R.drawable.ph9);
        postaccimg.add(R.drawable.ph10);

        postimg.add(R.drawable.ph6);
        postimg.add(R.drawable.ph1);
        postimg.add(R.drawable.p2);;
        postimg.add(R.drawable.ph3);
        postimg.add(R.drawable.ph4);
        postimg.add(R.drawable.ph5);
        postimg.add(R.drawable.ph7);
        postimg.add(R.drawable.ph8);
        postimg.add(R.drawable.ph9);
        postimg.add(R.drawable.ph10);

    }

    private void initview() {

        setdetails();

        StoryInterface storyInterface = new StoryInterface() {
            @Override
            public void onclick(int storyimg, String storyname, int storybigimg) {
                Log.e("TAG", "clicked on:" + sdimg + " " + proname);

                Intent i = new Intent(MainActivity.this, Positionstory.class);
                i.putExtra("photo", storyimg);
                i.putExtra("name", storyname);
                i.putExtra("bigphoto", storybigimg);
                startActivity(i);

            }
        };
        for (int i = 0; i < 9; i++) {
            User modelClass = new User();
            modelClass.setProfileimage(proimg.get(i));
            modelClass.setProfilename(proname.get(i));
            modelClass.setProfilebigimg(sdimg.get(i));
            data.add(modelClass);

            rcvmain = findViewById(R.id.rcvmain);
            instapoo adapter = new instapoo(data, storyInterface);


            LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            rcvmain.setLayoutManager(manager);
            rcvmain.setAdapter(adapter);
        }
    }

    private void setdetails() {
        proimg.add(R.drawable.ph6);
        proimg.add(R.drawable.ph1);
        proimg.add(R.drawable.p2);
        proimg.add(R.drawable.ph3);
        proimg.add(R.drawable.ph4);
        proimg.add(R.drawable.ph5);
        proimg.add(R.drawable.ph7);
        proimg.add(R.drawable.ph8);
        proimg.add(R.drawable.ph9);
        proimg.add(R.drawable.ph10);

        proname.add("Roman");
        proname.add("royal");
        proname.add("kings");
        proname.add("devil");
        proname.add("antim");
        proname.add("lions");
        proname.add("herom");
        proname.add("local");
        proname.add("riche");
        proname.add("newbe");

        sdimg.add(R.drawable.ph6);
        sdimg.add(R.drawable.ph1);
        sdimg.add(R.drawable.p2);
        sdimg.add(R.drawable.ph3);
        sdimg.add(R.drawable.ph4);
        sdimg.add(R.drawable.ph5);
        sdimg.add(R.drawable.ph7);
        sdimg.add(R.drawable.ph8);
        sdimg.add(R.drawable.ph9);
        sdimg.add(R.drawable.ph10);


    }
}