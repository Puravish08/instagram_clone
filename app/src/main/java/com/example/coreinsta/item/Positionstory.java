package com.example.coreinsta.item;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.musict.coreinstagram.R;

public class Positionstory extends AppCompatActivity {

    ImageView cirdisstoryimg;
    TextView txtdisstoryname;
    ImageView imgdisbig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_story);

        cirdisstoryimg = findViewById(R.id.cirdisstoryimg);
        txtdisstoryname = findViewById(R.id.txtdisstoryname);
        imgdisbig = findViewById(R.id.imgdisbig);
        displayview();
    }

    private void displayview() {
        int photo = getIntent().getIntExtra("photo",0);
        String name = getIntent().getStringExtra("name");
        int bigphoto = getIntent().getIntExtra("bigphoto",0);
        cirdisstoryimg.setImageResource(photo);
        txtdisstoryname.setText(name);
        imgdisbig.setImageResource(bigphoto);

    }
}