package com.a5.ngenemichael.btcexchanger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class StartUpScreen extends AppCompatActivity {
    private ImageView logoR;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_screen);

        i = new Intent(StartUpScreen.this,MainActivity.class);

    /*    logoR = (ImageView)findViewById(R.id.logo);
        // logoR.startAnimation(animation);
        logoR.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable)logoR.getBackground()).start();
            }
        });*/

        Thread thread = new Thread( ){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(i);


                }
            }
        };thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
