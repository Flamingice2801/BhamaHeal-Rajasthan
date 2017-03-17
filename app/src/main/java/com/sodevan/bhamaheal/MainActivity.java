package com.sodevan.bhamaheal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sodevan.bhamaheal.Activity.profile;

public class MainActivity extends AppCompatActivity {
    EditText bhID;
    Button Enter;
    public static final String MyPREFERENCES="login_prefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
        bhID= (EditText) findViewById(R.id.BhamashahID);
        Enter= (Button) findViewById(R.id.Enter);
        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=bhID.getText().toString();
                editor.putString("bhID",id);
                editor.commit();
                Intent i=new Intent(MainActivity.this,profile.class);
                startActivity(i);
                finish();

            }
        });
    }
}
