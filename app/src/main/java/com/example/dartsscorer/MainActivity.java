package com.example.dartsscorer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Point point;
    RadioGroup players;
    RadioButton p1;
    RadioButton p2;
    RadioButton p3;
    RadioButton p4;
    RadioGroup points;
    RadioButton p101;
    RadioButton p201;
    RadioButton p301;
    RadioButton p401;
    RadioButton p501;

    int chosen = 0;
    int chosen2 = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        players = (RadioGroup) findViewById(R.id.players);
        p1 = (RadioButton) findViewById(R.id.p1);
        p2 = (RadioButton) findViewById(R.id.p2);
        p3 = (RadioButton) findViewById(R.id.p3);
        p4 = (RadioButton) findViewById(R.id.p4);
        points = (RadioGroup) findViewById(R.id.points);
        p101 = (RadioButton) findViewById(R.id.p101);
        p201 = (RadioButton) findViewById(R.id.p201);
        p301 = (RadioButton) findViewById(R.id.p301);
        p401 = (RadioButton) findViewById(R.id.p401);
        p501 = (RadioButton) findViewById(R.id.p501);


        players.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (players.getCheckedRadioButtonId() == p1.getId()) {
                    chosen = 1;
                } else if (players.getCheckedRadioButtonId() == p2.getId()) {
                    chosen = 2;
                } else if (players.getCheckedRadioButtonId() == p3.getId()) {
                    chosen = 3;
                } else if (players.getCheckedRadioButtonId() == p4.getId()) {
                    chosen = 4;
                }
            }

        });

        points.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (points.getCheckedRadioButtonId() == p101.getId()) {
                    chosen2 = 101;
                } else if (points.getCheckedRadioButtonId() == p201.getId()) {
                    chosen2 = 201;
                } else if (points.getCheckedRadioButtonId() == p301.getId()) {
                    chosen2 = 301;
                } else if (points.getCheckedRadioButtonId() == p401.getId()) {
                    chosen2 = 401;
                }  else if (points.getCheckedRadioButtonId() == p501.getId()) {
                    chosen2 = 501;
                }
            }
        });

    }



    public void startGame(View v) {

//        if (chosen2 == 0) {
//            Toast.makeText(this, "Please select from points!", Toast.LENGTH_SHORT).show();
//        }

        if (chosen == 1) {
            Intent i = new Intent(MainActivity.this, Player1Activity.class);
            //i.setClass(this, Player1Activity.class);
            i.putExtra("sum", Integer.toString(chosen2));
            startActivity(i);
//            setResult(RESULT_OK, i);
        } else if (chosen == 2) {
            Intent i = new Intent(MainActivity.this, Player2Activity.class);
            //i.setClass(this, Player1Activity.class);
            i.putExtra("sum", Integer.toString(chosen2));
            startActivity(i);
        } else if (chosen == 3) {
            Intent i = new Intent(MainActivity.this, Player3Activity.class);
            //i.setClass(this, Player1Activity.class);
            i.putExtra("sum", Integer.toString(chosen2));
            startActivity(i);
        } else if (chosen == 4) {
            Intent i = new Intent(MainActivity.this, Player4Activity.class);
            //i.setClass(this, Player1Activity.class);
            i.putExtra("sum", Integer.toString(chosen2));
            startActivity(i);
        } else {
            Toast.makeText(this, "Please select the number of players!", Toast.LENGTH_SHORT).show();
        }


//        Intent i = new Intent();
//        i.putExtra("sum", chosen2);
   }

}