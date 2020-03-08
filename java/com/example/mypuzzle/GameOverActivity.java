package com.example.mypuzzle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GameOverActivity extends AppCompatActivity {

    TextView txtView;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        layout=findViewById(R.id.GameOverLayout);


        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        int defaultValue = 0;
        int previousHeighest = sharedPref.getInt(getString(R.string.saved_high_score_key), defaultValue);






        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainPuzzleGallery.class);
                startActivity(i);
            }
        });

        txtView=findViewById(R.id.TimeToComplete);
        Intent i=getIntent();
        int min=i.getIntExtra("Minutes",0);
        int sec=i.getIntExtra("Seconds",0);

        int CurrentScore = (min*60) + sec;

        txtView.setText("" + min + ":" + String.format("%02d", sec));

        if (previousHeighest<CurrentScore)
        {
            Toast.makeText(getApplicationContext(),"You were unable to beat your heighest",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Congratulation you have new heighest",Toast.LENGTH_LONG).show();
            SharedPreferences sharedPref1 = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref1.edit();
            editor.putInt(getString(R.string.saved_high_score_key), (min*60)+sec);
            editor.commit();
        }



    }




}
