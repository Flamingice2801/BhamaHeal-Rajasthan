package com.sodevan.bhamaheal.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sodevan.bhamaheal.MainActivity;
import com.sodevan.bhamaheal.R;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Typeface fa = Typeface.createFromAsset(getAssets() , "fontawesome-webfont.ttf") ;
        Typeface rob = Typeface.createFromAsset(getAssets() , "Roboto.ttf") ;


        TextView logo = (TextView)findViewById(R.id.logo) ;
        TextView bname = (TextView)findViewById(R.id.bname) ;
        logo.setTypeface(fa);
        bname.setTypeface(rob);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent change = new Intent(getApplicationContext() , MainActivity.class) ;
                startActivity(change);
                finish();
            }
        },2500) ;



    }
}
