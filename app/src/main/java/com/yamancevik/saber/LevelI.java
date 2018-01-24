package com.yamancevik.saber;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LevelI extends AppCompatActivity {

    ImageView sabre01, sabre02, sabre03, sabre04, sabre05, sabre06, sabre07, sabre08, sabre09;
    ImageView sure01, sure02, sure03;
    TextView textpuan, textzaman;
    int puan;
    ImageView[] sabreler, cukurlar;
    Handler handler;
    Runnable run;
    CountDownTimer timer;
    long remaningTime, zaman;
    Button dur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_i);

        puan = 0;
        sabre01 = (ImageView) findViewById(R.id.imageSaber);
        sabre02 = (ImageView) findViewById(R.id.imageSaber2);
        sabre03 = (ImageView) findViewById(R.id.imageSaber3);
        sabre04 = (ImageView) findViewById(R.id.imageSaber4);
        sabre05 = (ImageView) findViewById(R.id.imageSaber5);
        sabre06 = (ImageView) findViewById(R.id.imageSaber6);
        sabre07 = (ImageView) findViewById(R.id.imageSaber7);
        sabre08 = (ImageView) findViewById(R.id.imageSaber8);
        sabre09 = (ImageView) findViewById(R.id.imageSaber9);

        dur = (Button) findViewById(R.id.buttonDur);

        textpuan = (TextView) findViewById(R.id.textPuan);
        textzaman = (TextView) findViewById(R.id.textZaman);

        sabreler = new ImageView[] {sabre01, sabre02, sabre03, sabre04, sabre05, sabre06, sabre07, sabre08, sabre09};

        sakla();
        zamanbaslat(30000);
    }

    public void zamanbaslat(long sure){
        timer= new CountDownTimer(sure, 1000) {
            @Override
            public void onTick(long l) {
                remaningTime=l;
                textzaman.setText("Süre : " + l / 1000);
            }

            @Override
            public void onFinish() {
                textzaman.setText("Süren Bitti.");
                handler.removeCallbacks(run);
                saberClickRemove();
                Intent intent = new Intent(getApplicationContext(), Son.class);
                intent.putExtra("puan", textpuan.getText().toString());
                startActivity(intent);

            }
        }.start();
    }

    public void saberClickRemove(){
        for (ImageView saber : sabreler){
            saber.setClickable(false);
        }
    }

    public void saberClickAdd(){
        for (ImageView saber : sabreler){
            saber.setClickable(true);
        }
    }

    public void puanArttir(View view){
        puan++;
        textpuan.setText("PUANIN : " + puan);
    }

    public void sakla(){

        handler = new Handler();
        run = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : sabreler){
                    image.setVisibility(View.INVISIBLE);
                }
                Random rnd = new Random();
                int r = rnd.nextInt(9-0);
                sabreler[r].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 500);
            }
        };
        handler.post(run);
    }

    public void oyundur(View v){
        Button tiklanan = (Button) v;
        String komut = (String) tiklanan.getText();
        if(komut.equals("Oyunu Durdur")){
            handler.removeCallbacks(run);
            timer.cancel();
            saberClickRemove();
            tiklanan.setText("OYUNA DEVAM ET");
        }
        else {
            saberClickAdd();
            zamanbaslat(remaningTime);
            tiklanan.setText("Oyunu Durdur");
            handler.post(run);
        }
    }

}

