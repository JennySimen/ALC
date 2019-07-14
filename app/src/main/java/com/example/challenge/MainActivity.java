package com.example.challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button webBtn = (Button) findViewById(R.id.aboutBtn);
        Button profile = (Button) findViewById(R.id.profileBtn);

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webView= new Intent(MainActivity.this, Web.class);
                startActivity(webView);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent profileView = new Intent(MainActivity.this, Profile.class);
                startActivity(profileView);
            }
        });
    }

    public void openWeb(View view) {
        String webtext;
        webtext = ((Button)view).getText().toString();

        if(webtext.equals("About ALC")) {
            Intent webView= new Intent(this, Web.class);
            startActivity(webView);
        } else if (webtext.equals("My Profile")) {
            Intent profileView = new Intent(this, Profile.class);
            startActivity(profileView);
        }
    }
}
