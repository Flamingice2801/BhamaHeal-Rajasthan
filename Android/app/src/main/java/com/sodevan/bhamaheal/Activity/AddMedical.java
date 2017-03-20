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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.farbod.labelledspinner.LabelledSpinner;
import com.sodevan.bhamaheal.Interface.APIservice;
import com.sodevan.bhamaheal.R;

import java.util.ArrayList;
import java.util.List;

import io.victoralbertos.breadcumbs_view.BreadcrumbsView;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddMedical extends AppCompatActivity {
    ViewFlipper vf;
    BreadcrumbsView bc;
    private LinearLayout mLayout,mLayout2;
    List<EditText> allEds = new ArrayList<>();
    List<EditText> allEds2 = new ArrayList<>();
    Retrofit retrofit;
    APIservice apiservice;
    TextView tv_head;
    EditText et2,et3,et4,et5;
    LabelledSpinner ls;
    Typeface font;
    String blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medical);
        //INITIALIZATION
        ls= (LabelledSpinner) findViewById(R.id.your_labelled_spinner);
        List<String> a=new ArrayList<>();
        a.add("B+");
        a.add("A+");
        a.add("AB-");
        a.add("O+");
        a.add("O-");
        a.add("A-");
        a.add("AB+");
        a.add("B-");
        ls.setItemsArray(a);

        et2= (EditText) findViewById(R.id.et2);
        et3= (EditText) findViewById(R.id.et3);
        et4= (EditText) findViewById(R.id.et4);
        et5= (EditText) findViewById(R.id.et5);



        vf= (ViewFlipper) findViewById(R.id.viewflip);
        bc= (BreadcrumbsView) findViewById(R.id.breadcrumbs);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit=new Retrofit.Builder()
                .baseUrl(getString(R.string.hosturl))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiservice=retrofit.create(APIservice.class);

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


        ls.setOnItemChosenListener(new LabelledSpinner.OnItemChosenListener() {
            @Override
            public void onItemChosen(View labelledSpinner, AdapterView<?> adapterView, View itemView, int position, long id) {
                Log.d("TAGaas",position+"");
                switch (position){
                    case 0: blood="B+";
                        break;
                    case 1:blood="A+";
                        break;
                    case 2:blood="AB-";
                        break;
                    case 3:blood="O+";
                        break;
                    case 4:blood="O-";
                        break;
                    case 5:blood="A_";
                        break;
                    case 6:blood="AB+";
                        break;
                    case 7:blood="B-";
                        break;
                }
            }

            @Override
            public void onNothingChosen(View labelledSpinner, AdapterView<?> adapterView) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (String.valueOf(vf.indexOfChild(vf.getCurrentView()))=="0"){




                    String hb=et2.getText().toString();
                    String rbc=et3.getText().toString();
                    String plate=et4.getText().toString();
                    String chol=et5.getText().toString();
                    Call<String> writec =apiservice.writeHealthOne("1234",chol,blood,hb,rbc,plate);
                    writec.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Log.d("TAG",response.body());
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    Log.d("TAG","here");
                }
                if (String.valueOf(vf.indexOfChild(vf.getCurrentView()))=="1"){
                    EditText ett1,ett2,ett3,ett4,ett5,ett6;
                    ett1= (EditText) findViewById(R.id.lefteye);
                    ett2= (EditText) findViewById(R.id.righteye);
                    ett3= (EditText) findViewById(R.id.weight);
                    ett4=(EditText)  findViewById(R.id.height);
                    ett5= (EditText) findViewById(R.id.sugar);
                    ett6= (EditText) findViewById(R.id.remark);
                    String lefteye=ett1.getText().toString();
                    String righteye=ett2.getText().toString();
                    String wght=ett3.getText().toString();
                    String height=ett4.getText().toString();
                    String sugar=ett5.getText().toString();
                    String remarks=ett6.getText().toString();
                    Call<String> writesecond = apiservice.writeHealthTwo("1234",lefteye,righteye,height,wght,sugar,remarks);
                    writesecond.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                }

                if(String.valueOf(vf.indexOfChild(vf.getCurrentView()))=="2") {
                    String s="";
                    for (int i = 0; i < allEds.size(); i++) {
                        Log.d("TAG", allEds.get(i).getText().toString());
                        s=s+allEds.get(i).getText().toString()+"+";
                        Call<String> writehhist=apiservice.writeHealthThree("987","1234",s,"HISTORY");
                        writehhist.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                Log.d("TAG",response.body());
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                    }
                }
                if(String.valueOf(vf.indexOfChild(vf.getCurrentView()))=="2") {
                    String ss="";
                    for (int i = 0; i < allEds2.size(); i++) {
                        Log.d("TAG2", allEds2.get(i).getText().toString());
                        ss=ss+allEds2.get(i).getText().toString()+"+";
                        Call<String> writemedic=apiservice.writeHealthThree("987","1234",ss,"MEDICINE");
                        writemedic.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                Log.d("TAG",response.body());
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
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

