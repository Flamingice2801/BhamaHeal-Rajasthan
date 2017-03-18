package com.sodevan.bhamaheal.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sodevan.bhamaheal.R;

public class profile extends AppCompatActivity {
    public static final String MyPREFERENCES="login_prefs";
    SharedPreferences sharedPreferences;
    String bhID;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        bhID=sharedPreferences.getString("bhID",null);
        rl= (RelativeLayout) findViewById(R.id.ProfRel);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(150,150);
        TextView tv=new TextView(this);
        lp.setMargins(20,10,10,20);
        tv.setLayoutParams(lp);
        tv.setWidth(10);
        tv.setText("heyyy");

        rl.addView(tv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(profile.this,AddMedical.class);
                startActivity(i);
            }
        });
    }

}
