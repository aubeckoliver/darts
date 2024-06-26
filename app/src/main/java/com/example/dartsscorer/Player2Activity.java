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


public class Player2Activity extends AppCompatActivity {

    TextView score1;
    TextView score2;
    TextView score3;
    TextView score4;
    TextView score5;
    TextView score6;
    TextView sumScore;
    TextView sumScore2;
    List<Point> points;
    String lastScore1;
    String lastScore2;
    String lastScore3;
    List<History> history;

    //List<TextView> scores;

    int sum = 0, sum2 = 0;
    boolean wasPre;
    char pre;
    int size = 0;
    int size2 = 0;
    //`int point;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2);
        sumScore = findViewById(R.id.scoreSum);
        sumScore2 = findViewById(R.id.scoreSum2);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score3 = findViewById(R.id.score3);
        score4 = findViewById(R.id.score4);
        score5 = findViewById(R.id.score5);
        score6 = findViewById(R.id.score6);
        points = new ArrayList<>();
        history = new ArrayList<>();

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            sum = Integer.parseInt(extra.getString("sum"));
            sum2 = Integer.parseInt(extra.getString("sum"));
        }
        sumScore.setText(Integer.toString(sum));
        sumScore2.setText(Integer.toString(sum2));
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

//        lastScore1 = score1.getText().toString();
//        ;
//        lastScore2 = score2.getText().toString();
//        lastScore3 = score3.getText().toString();

        size = points.size();
        size2 = size2 + 1;
        wasPre = false;

        History h = new History(points.get(size - 1).point, sum, sum2);
        history.add(h);


        if (size2 % 6 == 1) {

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

//                score1.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));

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
        if (size2 % 6 == 2) {

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
        if (size2 % 6 == 3) {

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

        if (size2 % 6 == 4) {

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
                    if (sum2 == 0) {
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

                Point p1 = points.get(size - 2);
                Point p2 = points.get(size - 1);
                points.add(p1);
                points.add(p2);
            }
        }
        if (size2 % 6 == 5) {

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
                    if (sum2 == 0) {
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
        if (size2 % 6 == 0) {

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
                    if (sum2 == 0) {
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
                        score4.getText() == "" && score5.getText() == "" && score6.getText() == "") {
                    score1.setText(Integer.toString(history.get(history.size() - 6).lastScore));
                    score2.setText(Integer.toString(history.get(history.size() - 5).lastScore));
                    score3.setText(Integer.toString(history.get(history.size() - 4).lastScore));
                    score4.setText(Integer.toString(history.get(history.size() - 3).lastScore));
                    score5.setText(Integer.toString(history.get(history.size() - 2).lastScore));
                    score6.setText(Integer.toString(history.get(history.size() - 1).lastScore));
                    sum = history.get(history.size() - 1).getSum();
                    sum2 = history.get(history.size() - 1).getSum2();
                    sumScore.setText(Integer.toString(sum));
                    sumScore2.setText(Integer.toString(sum2));
                }
                if (size2 % 6 == 1 ) {
                    score1.setText("");
                    sum = history.get(history.size() - 1).getSum();
                    sumScore.setText(Integer.toString(sum));
                }
                if (size2 % 6 == 2 ) {
                    score2.setText("");
                    sum = history.get(history.size() - 1).getSum();
                    sumScore.setText(Integer.toString(sum));
                }
                if (size2 % 6 == 3 ) {
                    score3.setText("");
                    sum = history.get(history.size() - 1).getSum();
                    sumScore.setText(Integer.toString(sum));
                }

                if (size2 % 6 == 4 ) {
                    score4.setText("");
                    sum2 = history.get(history.size() - 1).getSum2();
                    sumScore2.setText(Integer.toString(sum2));
                }
                if (size2 % 6 == 5 ) {
                    score5.setText("");
                    sum2 = history.get(history.size() - 1).getSum2();
                    sumScore2.setText(Integer.toString(sum2));
                }
                if (size2 % 6 == 0 ) {
                    score6.setText("");
                    sum2 = history.get(history.size() - 1).getSum2();
                    sumScore2.setText(Integer.toString(sum2));
                }

                history.remove(history.size() - 1);
                size2 = size2 - 1;
            }
            //points.remove(points.size());
            //sumScore.setText(Integer.toString(sums[sums.length-1]));

        }
    }

}