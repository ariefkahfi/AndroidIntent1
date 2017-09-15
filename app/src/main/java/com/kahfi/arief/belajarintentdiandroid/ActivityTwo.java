package com.kahfi.arief.belajarintentdiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityTwo extends AppCompatActivity {



    @BindView(R.id.textIntent)TextView textIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        ButterKnife.bind(this);

        textIntent.setText(getIntent().getStringExtra("inten"));

    }



}
