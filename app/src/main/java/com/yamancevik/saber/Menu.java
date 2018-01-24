package com.yamancevik.saber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void oyna(View view){

        Intent intent = new Intent(getApplicationContext(), LevelI.class);
        startActivity(intent);
    }
}
