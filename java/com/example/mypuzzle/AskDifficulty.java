package com.example.mypuzzle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AskDifficulty extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_difficulty);

        Intent intent = getIntent();
        final String assetName = intent.getStringExtra("assetName");

        btn1=findViewById(R.id.Noob);
        btn2=findViewById(R.id.Easy);
        btn3=findViewById(R.id.Normal);
        btn4=findViewById(R.id.Hard);
        btn5=findViewById(R.id.Expert);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PuzzleActivity.class);
                intent.putExtra("assetNames", assetName);
                intent.putExtra("Level",1);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PuzzleActivity.class);
                intent.putExtra("assetNames", assetName);
                intent.putExtra("Level",2);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PuzzleActivity.class);
                intent.putExtra("assetNames", assetName);
                intent.putExtra("Level",3);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PuzzleActivity.class);
                intent.putExtra("assetNames", assetName);
                intent.putExtra("Level",4);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PuzzleActivity.class);
                intent.putExtra("assetNames", assetName);
                intent.putExtra("Level",5);
                startActivity(intent);
            }
        });
    }
}
