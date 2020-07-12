package com.e.projecthelm.admin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.e.projecthelm.R;
import com.e.projecthelm.session.PrefSetting;
import com.e.projecthelm.session.SessionManager;
import com.e.projecthelm.users.LoginActivity;

public class HomeAdminActivity extends AppCompatActivity {

    CardView cardexit, cardDataHelm, cardInputHelm, cardProfile;

    SessionManager session;
    SharedPreferences prefs;
    PrefSetting prefSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        prefSetting = new PrefSetting(this);
        prefs = prefSetting.getSharePreference();

        session = new SessionManager(HomeAdminActivity.this);

        prefSetting.isLogin(session, prefs);

        cardexit = (CardView) findViewById(R.id.cardexit);
        cardDataHelm = (CardView) findViewById(R.id.cardDataHelm);
        cardInputHelm = (CardView) findViewById(R.id.cardInputHelm);
        cardProfile = (CardView) findViewById(R.id.cardProfile);

        cardexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setLogin(false);
                session.setSessid(0);
                Intent i = new Intent(HomeAdminActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        cardDataHelm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdminActivity.this, ActivityDatahelm.class);
                startActivity(i);
                finish();
            }
        });

        cardInputHelm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdminActivity.this, InputDataHelm.class);
                startActivity(i);
                finish();
            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdminActivity.this, Profile.class);
                startActivity(i);
                finish();
            }
        });

    }
}

