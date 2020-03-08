package com.example.mypuzzle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity<PreviousCondition> extends AppCompatActivity {

    TextView txtView;
    RelativeLayout layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView=(TextView)findViewById(R.id.TapToPlay);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int defaultValue = 0;
        int musicValue = preferences.getInt(getString(R.string.MusicCondition), defaultValue);

        Toast.makeText(getApplicationContext(),Integer.toString(musicValue),Toast.LENGTH_SHORT).show();

        if (musicValue==1)
        {
            Intent i=new Intent(this,MyService.class);
            startService(i);
        }





        layout=findViewById(R.id.LayoutId);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainPuzzleGallery.class);
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent=new Intent(getApplicationContext(),MyService.class);
        stopService(intent);
    }
}
