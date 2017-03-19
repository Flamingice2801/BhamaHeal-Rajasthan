package com.sodevan.bhamaheal.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.sodevan.bhamaheal.R;

import java.util.ArrayList;
import java.util.List;

import io.victoralbertos.breadcumbs_view.BreadcrumbsView;

public class AddMedical extends AppCompatActivity {
        ViewFlipper vf;
        BreadcrumbsView bc;
    private LinearLayout mLayout,mLayout2;
    List<EditText> allEds = new ArrayList<>();
    List<EditText> allEds2 = new ArrayList<>();

    TextView tv_head;

    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medical);
        vf= (ViewFlipper) findViewById(R.id.viewflip);
        bc= (BreadcrumbsView) findViewById(R.id.breadcrumbs);

        tv_head= (TextView) findViewById(R.id.Heading_history);
        Log.d("TAG",String.valueOf(vf.indexOfChild(vf.getCurrentView())));

        font=Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        mLayout= (LinearLayout) findViewById(R.id.thirdlay);
        mLayout2= (LinearLayout) findViewById(R.id.forthlay);
        vf.setInAnimation(in);
        vf.setOutAnimation(out);
        TextView tv= (TextView) findViewById(R.id.one);
        TextView tv2= (TextView) findViewById(R.id.two);
        tv2.setTypeface(font);
        tv.setTypeface(font);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                EditText et=new EditText(AddMedical.this);
                et.setLayoutParams(lp);
                et.setEms(10);
                et.setHint("HINT");
                int id=1;
                et.setId(id);
                mLayout2.addView(et);
                allEds2.add(et);
                Log.d("TAG","added");

            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                EditText et=new EditText(AddMedical.this);
                et.setLayoutParams(layoutParams);
                et.setEms(10);
                et.setHint("HINT");
                int id=1;
                et.setId(id);
                mLayout.addView(et);
                allEds.add(et);
                Log.d("TAG","added");

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
            if(String.valueOf(vf.indexOfChild(vf.getCurrentView()))=="1") {
                for (int i = 0; i < allEds.size(); i++) {
                    Log.d("TAG", allEds.get(i).getText().toString());
                }
            }
                if(String.valueOf(vf.indexOfChild(vf.getCurrentView()))=="2") {
                    for (int i = 0; i < allEds2.size(); i++) {
                        Log.d("TAG2", allEds2.get(i).getText().toString());

                    }
                }


                Log.d("TAG", String.valueOf(vf.indexOfChild(vf.getCurrentView())));
                try{bc.nextStep();}
                catch (Exception e){Log.d("TAG","send intent now");

                Intent i=new Intent(AddMedical.this,profile.class);
                    startActivity(i);
                ;}
                vf.showNext();
            }
        });
    }

}
