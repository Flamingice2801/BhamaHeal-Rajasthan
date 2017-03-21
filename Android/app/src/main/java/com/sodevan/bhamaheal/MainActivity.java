package com.sodevan.bhamaheal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sodevan.bhamaheal.Activity.profile;
import com.sodevan.bhamaheal.Interface.APIservice;
import com.sodevan.bhamaheal.Models.BhamData;

import java.util.Calendar;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText bhID,UID;
    Button Enter;
    public static final String MyPREFERENCES="login_prefs";
    Retrofit retrofit;
    APIservice apiservice;
    boolean isLoggedIn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface fa = Typeface.createFromAsset(getAssets() , "fontawesome-webfont.ttf") ;
        TextView logo = (TextView)findViewById(R.id.logo2) ;

        logo.setTypeface(fa);


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit=new Retrofit.Builder()
                .baseUrl("https://apitest.sewadwaar.rajasthan.gov.in/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiservice=retrofit.create(APIservice.class);


        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
        bhID= (EditText) findViewById(R.id.BhamashahID);
        UID= (EditText) findViewById(R.id.UID);
        Enter= (Button) findViewById(R.id.Enter);
        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String id=bhID.getText().toString();
                Call<BhamData> call=apiservice.callbham(id);
                call.enqueue(new Callback<BhamData>() {
                    @Override
                    public void onResponse(Call<BhamData> call, Response<BhamData> response) {
                            for(int i=0;(i<response.body().getFamilyDetails().size())&&isLoggedIn==false;i++){
                                Log.d("TAG",response.body().getFamilyDetails().get(i).getMID());
                                if(UID.getText().toString().equals(response.body().getFamilyDetails().get(i).getMID())){
                                    String dob=response.body().getFamilyDetails().get(i).getDOB();
                                    String mobile=response.body().getHofDetails().getMOBILENO();
                                    String name=response.body().getFamilyDetails().get(i).getNAMEENG();


                                    String[] splitted=dob.split("/");
                                    Calendar now = Calendar.getInstance();   // Gets the current date and time
                                    int year = now.get(Calendar.YEAR);
                                    int age=year-Integer.parseInt(splitted[2]);
                                    isLoggedIn=true;

                                    editor.putString("loggedin","true");
                                    editor.putString("age",age+"");
                                    editor.putString("mobile",mobile);
                                    editor.putString("name",name);
                                    editor.putString("bhID", id);
                                    editor.putString("memid",UID.getText().toString());
                                    editor.commit();

                                }
                                else{
                                    isLoggedIn=false;
                                }

                            }

                        Intent i=new Intent(MainActivity.this, profile.class);
                        startActivity(i);

                    }

                    @Override
                    public void onFailure(Call<BhamData> call, Throwable t) {

                    }
                });

            }
        });
    }
}
