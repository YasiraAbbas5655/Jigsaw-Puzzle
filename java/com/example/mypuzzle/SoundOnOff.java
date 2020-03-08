package com.example.mypuzzle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SoundOnOff extends AppCompatActivity {

    Button btn;
    Switch Music,Sound,Preview;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_on_off);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int defaultValue = 0;
        int musicValue = preferences.getInt(getString(R.string.MusicCondition), defaultValue);
        int soundValue = preferences.getInt(getString(R.string.SoundCondition), defaultValue);
        int PreviewValue = preferences.getInt(getString(R.string.Preview), defaultValue);





        intent=new Intent(getApplicationContext(),MyService.class);
        btn=findViewById(R.id.ApplySettingButton);
        Music=findViewById(R.id.MusicOnOff);
        Sound=findViewById(R.id.SoundOnOff);
        Preview=findViewById(R.id.EnablePreview);

        if (musicValue==1)
        {
            Music.setChecked(true);
        }

        if (soundValue==1)
        {
            Sound.setChecked(true);
        }

        if (PreviewValue==1)
        {
            Preview.setChecked(true);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(Music.isChecked()==true)
                {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(getString(R.string.MusicCondition), 1);
                    editor.commit();
                    startService(intent);
                }
                else
                {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(getString(R.string.MusicCondition), 0);
                    editor.commit();
                    stopService(intent);
                }

                if(Sound.isChecked()==true)
                {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(getString(R.string.SoundCondition), 1);
                    editor.commit();
                }
                else
                {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(getString(R.string.SoundCondition), 0);
                    editor.commit();
                }


                if(Preview.isChecked()==true)
                {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(getString(R.string.Preview), 1);
                    editor.commit();
                }
                else
                {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(getString(R.string.Preview), 0);
                    editor.commit();
                }


                Toast.makeText(getApplicationContext(),"Settings Applied",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),MainPuzzleGallery.class);
                startActivity(intent);


            }
        });
    }
}
