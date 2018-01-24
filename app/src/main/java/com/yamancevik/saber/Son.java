package com.yamancevik.saber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Son extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son);

        TextView puaniniz = (TextView) findViewById(R.id.textPuancikti);

        Intent intent = getIntent();

        String gelenpuan = intent.getStringExtra("puan");

        puaniniz.setText(gelenpuan);
    }
    public void tekrar(View view){
        Intent intent = new Intent(getApplicationContext(), LevelI.class);
        startActivity(intent);
    }
}
