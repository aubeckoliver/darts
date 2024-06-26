package com.example.dartsscorer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import java.util.List;


public class Player3Activity extends AppCompatActivity {

    TextView score1;
    TextView score2;
    TextView score3;
    TextView score4;
    TextView score5;
    TextView score6;
    TextView score7;
    TextView score8;
    TextView score9;
    TextView sumScore;
    TextView sumScore2;
    TextView sumScore3;
    List<Point> points;
    List<History> history;


    int sum = 0, sum2 = 0, sum3 = 0 ;
    boolean wasPre;
    char pre;
    int size = 0;
    int size2 = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player3);
        sumScore = findViewById(R.id.scoreSum);
        sumScore2 = findViewById(R.id.scoreSum2);
        sumScore3 = findViewById(R.id.scoreSum3);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score3 = findViewById(R.id.score3);
        score4 = findViewById(R.id.score4);
        score5 = findViewById(R.id.score5);
        score6 = findViewById(R.id.score6);
        score7 = findViewById(R.id.score7);
        score8 = findViewById(R.id.score8);
        score9 = findViewById(R.id.score9);

        points = new ArrayList<>();
        history = new ArrayList<>();

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            sum = Integer.parseInt(extra.getString("sum"));
            sum2 = Integer.parseInt(extra.getString("sum"));
            sum3 = Integer.parseInt(extra.getString("sum"));
        }
        sumScore.setText(Integer.toString(sum));
        sumScore2.setText(Integer.toString(sum2));
        sumScore3.setText(Integer.toString(sum3));

    }


    public void number(View v) {
        Button b = (Button) v;
        String text = b.getText().toString();
        int point = Integer.parseInt(text);
        if (wasPre == false) {
            pre = ' ';
        }
        Point p = new Point(pre, point);
        points.add(p);

        size = points.size();
        size2 = size2 + 1;
        wasPre = false;

        History h = new History(points.get(size - 1).point, sum, sum2, sum3);
        history.add(h);


        if (size2 % 9 == 1) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if ((sum - points.get(size - 1).point) >= 0) {
                score1.setText("");
                score2.setText("");
                score3.setText("");
                score4.setText("");
                score5.setText("");
                score6.setText("");
                score7.setText("");
                score8.setText("");
                score9.setText("");


                if (points.get(points.size() - 1).pre == 'D') {
                    score1.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score1.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score1.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }


                if (sum - points.get(size - 1).point < 0) {
                    sumScore.setText(Integer.toString(sum));
                    score1.setText("");
                    score2.setText("");
                    score3.setText("");
                } else {
                    sum = sum - points.get(size - 1).point;
                    sumScore.setText(Integer.toString(sum));
                    if (sum == 0) {
                        Toast.makeText(this, "Player1 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore.setText(Integer.toString(sum));
                score1.setText("");
                score2.setText("");
                score3.setText("");
                size2 = size2 + 2;
            }
        }
        if (size2 % 9 == 2) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if (sum - (points.get(size - 1).point + points.get(size - 2).point) >= 0) {


                if (points.get(points.size() - 1).pre == 'D') {
                    score2.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score2.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score2.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }


                if (sum - (points.get(size - 1).point + points.get(size - 2).point) < 0) {
                    sumScore.setText(Integer.toString(sum));
                    score1.setText("");
                    score2.setText("");
                    score3.setText("");
                } else {
                    sum = sum - points.get(size - 2).point;
                    sumScore.setText(Integer.toString(sum));
                    if (sum == 0) {
                        Toast.makeText(this, "Player1 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore.setText(Integer.toString(sum));
                score1.setText("");
                score2.setText("");
                score3.setText("");
                size2 = size2 + 1;
            }
        }
        if (size2 % 9 == 3) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if (sum - (points.get(size - 1).point + points.get(size - 2).point + points.get(size - 3).point) >= 0) {

                if (points.get(points.size() - 1).pre == 'D') {
                    score3.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score3.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score3.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }


                if (sum - (points.get(size - 1).point + points.get(size - 2).point + points.get(size - 3).point) < 0) {
                    sumScore.setText(Integer.toString(sum));
                    score1.setText("");
                    score2.setText("");
                    score3.setText("");
                } else {
                    sum = sum - points.get(size - 3).point;
                    sumScore.setText(Integer.toString(sum));
                    if (sum == 0) {
                        Toast.makeText(this, "Player1 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore.setText(Integer.toString(sum));
                score1.setText("");
                score2.setText("");
                score3.setText("");
            }
        }

        if (size2 % 9 == 4) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if ((sum2 - points.get(size - 1).point) >= 0) {
                score4.setText("");
                score5.setText("");
                score6.setText("");

                if (points.get(points.size() - 1).pre == 'D') {
                    score4.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score4.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score4.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }


                if (sum2 - points.get(size - 1).point < 0) {
                    sumScore2.setText(Integer.toString(sum2));
                    score4.setText("");
                    score5.setText("");
                    score6.setText("");
                } else {
                    sum2 = sum2 - points.get(size - 1).point;
                    sumScore2.setText(Integer.toString(sum2));
                    if (sum == 0) {
                        Toast.makeText(this, "Player2 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore2.setText(Integer.toString(sum2));
                score4.setText("");
                score5.setText("");
                score6.setText("");

                size2 = size2 + 2;
            }
        }
        if (size2 % 9 == 5) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if (sum2 - (points.get(size - 1).point + points.get(size - 2).point) >= 0) {

                if (points.get(points.size() - 1).pre == 'D') {
                    score5.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score5.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score5.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }

                if (sum2 - (points.get(size - 1).point + points.get(size - 2).point) < 0) {
                    sumScore2.setText(Integer.toString(sum2));
                    score4.setText("");
                    score5.setText("");
                    score6.setText("");
                } else {
                    sum2 = sum2 - points.get(size - 2).point;
                    sumScore2.setText(Integer.toString(sum2));
                    if (sum == 0) {
                        Toast.makeText(this, "Player2 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore2.setText(Integer.toString(sum2));
                score4.setText("");
                score5.setText("");
                score6.setText("");

                size2 = size2 + 1;
            }

        }
        if (size2 % 9 == 6) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if (sum2 - (points.get(size - 1).point + points.get(size - 2).point + points.get(size - 3).point) >= 0) {

                if (points.get(points.size() - 1).pre == 'D') {
                    score6.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score6.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score6.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }

                if (sum2 - (points.get(size - 1).point + points.get(size - 2).point + points.get(size - 3).point) < 0) {
                    sumScore2.setText(Integer.toString(sum2));
                    score4.setText("");
                    score5.setText("");
                    score6.setText("");
                } else {
                    sum2 = sum2 - points.get(size - 3).point;
                    sumScore2.setText(Integer.toString(sum2));
                    if (sum == 0) {
                        Toast.makeText(this, "Player2 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore2.setText(Integer.toString(sum2));
                score4.setText("");
                score5.setText("");
                score6.setText("");
            }

        }
        if (size2 % 9 == 7) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if ((sum3 - points.get(size - 1).point) >= 0) {
                score7.setText("");
                score8.setText("");
                score9.setText("");

                if (points.get(points.size() - 1).pre == 'D') {
                    score7.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score7.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score7.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }


                if (sum3 - points.get(size - 1).point < 0) {
                    sumScore.setText(Integer.toString(sum3));
                    score7.setText("");
                    score8.setText("");
                    score9.setText("");
                } else {
                    sum3 = sum3 - points.get(size - 1).point;
                    sumScore3.setText(Integer.toString(sum3));
                    if (sum3 == 0) {
                        Toast.makeText(this, "Player3 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore3.setText(Integer.toString(sum3));
                score7.setText("");
                score8.setText("");
                score9.setText("");

                size2 = size2 + 2;
            }
        }
        if (size2 % 9 == 8) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if (sum3 - (points.get(size - 1).point + points.get(size - 2).point) >= 0) {

                if (points.get(points.size() - 1).pre == 'D') {
                    score8.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score8.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score8.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }

                if (sum3 - (points.get(size - 1).point + points.get(size - 2).point) < 0) {
                    sumScore3.setText(Integer.toString(sum3));
                    score7.setText("");
                    score8.setText("");
                    score9.setText("");
                } else {
                    sum3 = sum3 - points.get(size - 2).point;
                    sumScore3.setText(Integer.toString(sum3));
                    if (sum3 == 0) {
                        Toast.makeText(this, "Player3 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore3.setText(Integer.toString(sum3));
                score7.setText("");
                score8.setText("");
                score9.setText("");

                size2 = size2 + 1;
            }

        }
        if (size2 % 9 == 0) {

            if (points.get(size - 1).pre == 'D') {
                points.get(size - 1).point = points.get(size - 1).point * 2;
            }
            if (points.get(size - 1).pre == 'T') {
                points.get(size - 1).point = points.get(size - 1).point * 3;
            }

            if (sum3 - (points.get(size - 1).point + points.get(size - 2).point + points.get(size - 3).point) >= 0) {

                if (points.get(points.size() - 1).pre == 'D') {
                    score9.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score9.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score9.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }

                if (sum3 - (points.get(size - 1).point + points.get(size - 2).point + points.get(size - 3).point) < 0) {
                    sumScore3.setText(Integer.toString(sum3));
                    score7.setText("");
                    score8.setText("");
                    score9.setText("");
                } else {
                    sum3 = sum3 - points.get(size - 3).point;
                    sumScore3.setText(Integer.toString(sum3));
                    if (sum3 == 0) {
                        Toast.makeText(this, "Player3 won", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setClass(this, MainActivity.class);
                        startActivity(i);
                    }
                }
            } else {
                sumScore3.setText(Integer.toString(sum3));
                score7.setText("");
                score8.setText("");
                score9.setText("");
            }

        }
    }


    public void operator(View v) {
        Button b = (Button) v;
        String text = b.getText().toString();
        if (text.equals("Double")) {
            pre = 'D';
            wasPre = true;
        }
        if (text.equals("Triple")) {
            pre = 'T';
            wasPre = true;
        }
//        wasPre = true;
        if (text.equals("C")) {
            if(size2 > 0) {
                if (score1.getText() == "" && score2.getText() == "" && score3.getText() == "" &&
                        score4.getText() == "" && score5.getText() == "" && score6.getText() == "" &&
                        score7.getText() == "" && score8.getText() == "" && score9.getText() == "") {
                    score1.setText(Integer.toString(history.get(history.size() - 9).lastScore));
                    score2.setText(Integer.toString(history.get(history.size() - 8).lastScore));
                    score3.setText(Integer.toString(history.get(history.size() - 7).lastScore));
                    score4.setText(Integer.toString(history.get(history.size() - 6).lastScore));
                    score5.setText(Integer.toString(history.get(history.size() - 5).lastScore));
                    score6.setText(Integer.toString(history.get(history.size() - 4).lastScore));
                    score7.setText(Integer.toString(history.get(history.size() - 3).lastScore));
                    score8.setText(Integer.toString(history.get(history.size() - 2).lastScore));
                    score9.setText(Integer.toString(history.get(history.size() - 1).lastScore));

                    sum = history.get(history.size() - 1).getSum();
                    sum2 = history.get(history.size() - 1).getSum2();
                    sum3 = history.get(history.size() - 1).getSum3();
                    sumScore.setText(Integer.toString(sum));
                    sumScore2.setText(Integer.toString(sum2));
                    sumScore3.setText(Integer.toString(sum3));
                }
                if (size2 % 9 == 1 ) {
                    score1.setText("");
                    sum = history.get(history.size() - 1).getSum();
                    sumScore.setText(Integer.toString(sum));
                }
                if (size2 % 9 == 2 ) {
                    score2.setText("");
                    sum = history.get(history.size() - 1).getSum();
                    sumScore.setText(Integer.toString(sum));
                }
                if (size2 % 9 == 3 ) {
                    score3.setText("");
                    sum = history.get(history.size() - 1).getSum();
                    sumScore.setText(Integer.toString(sum));
                }

                if (size2 % 9 == 4 ) {
                    score4.setText("");
                    sum2 = history.get(history.size() - 1).getSum2();
                    sumScore2.setText(Integer.toString(sum2));
                }
                if (size2 % 9 == 5 ) {
                    score5.setText("");
                    sum2 = history.get(history.size() - 1).getSum2();
                    sumScore2.setText(Integer.toString(sum2));
                }
                if (size2 % 9 == 6 ) {
                    score6.setText("");
                    sum2 = history.get(history.size() - 1).getSum2();
                    sumScore2.setText(Integer.toString(sum2));
                }

                if (size2 % 9 == 7 ) {
                    score7.setText("");
                    sum3 = history.get(history.size() - 1).getSum3();
                    sumScore3.setText(Integer.toString(sum3));
                }
                if (size2 % 9 == 8 ) {
                    score8.setText("");
                    sum3 = history.get(history.size() - 1).getSum3();
                    sumScore3.setText(Integer.toString(sum3));
                }
                if (size2 % 9 == 0 ) {
                    score9.setText("");
                    sum3 = history.get(history.size() - 1).getSum3();
                    sumScore3.setText(Integer.toString(sum3));
                }

                history.remove(history.size() - 1);
                size2 = size2 - 1;
            }
            //points.remove(points.size());
            //sumScore.setText(Integer.toString(sums[sums.length-1]));

        }
    }

}