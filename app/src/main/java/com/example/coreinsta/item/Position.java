package com.example.coreinsta.item;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.musict.coreinstagram.R;

public class Position extends AppCompatActivity {

    ImageView cirpostdisaccimg;
    TextView txtdispostname;
    ImageView imgdispostphoto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_post);

        cirpostdisaccimg = findViewById(R.id.cirpostdisaccimg);
        txtdispostname = findViewById(R.id.txtdispostname);
        imgdispostphoto = findViewById(R.id.imgdispostphoto);

        displaypostview();

    }

    private void displaypostview() {
        int photos = getIntent().getIntExtra("photos",0);
        String names = getIntent().getStringExtra("names");
        int accphoto = getIntent().getIntExtra("accphoto",0);

        cirpostdisaccimg.setImageResource(photos);
        txtdispostname.setText(names);
        imgdispostphoto.setImageResource(accphoto);

    }
}