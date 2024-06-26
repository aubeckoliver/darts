package com.example.dartsscorer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Player1Activity extends AppCompatActivity {

    TextView score1;
    TextView score2;
    TextView score3;
    TextView player;
    TextView sumScore;
    List<Point> points;
    List<TextView> scores;
//    int[] sums;
    char pre = ' ';
    int sum = 0;
    boolean wasPre;
    int size = 0;
    int size2 = 0;
    int lastNumber = 0;
    int lastSum = 0;
    String lastScore1;
    String lastScore2;
    String lastScore3;
    List<History> history;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1);
        sumScore = findViewById(R.id.scoreSum);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score3 = findViewById(R.id.score3);
        player = findViewById(R.id.player);
        points = new ArrayList<>();
        scores = new ArrayList<>();
//        sums = new int[0];
        scores.add(score1);
        scores.add(score2);
        scores.add(score3);
        history = new ArrayList<>();

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            sum = Integer.parseInt(extra.getString("sum"));
        }
        sumScore.setText(Integer.toString(sum));
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

        History h = new History(points.get(size - 1).point, sum);
        history.add(h);


//        lastSum = sum;
//        sums = new int[size2];
//        sums[sums.length-1] = lastSum;

//        if (size > 2) {
//            if ((sum - points.get(size-1).point) < 0) {
//                sumScore.setText(Integer.toString(sum));
//                score1.setText("");
//                score2.setText("");
//                score3.setText("");
//            } else if (sum - (points.get(size - 1).point + points.get(size - 2).point) < 0) {
//                sumScore.setText(Integer.toString(sum));
//                score1.setText("");
//                score2.setText("");
//                score3.setText("");
//            } else if (sum - (points.get(size - 1).point + points.get(size - 2).point + points.get(size - 3).point) < 0) {
//                sumScore.setText(Integer.toString(sum));
//                score1.setText("");
//                score2.setText("");
//                score3.setText("");
//            }
//        }

//        if (size % 3 == 1 && size != 1) {
//            if(sum - (points.get(size-1).point + points.get(size-2).point + points.get(size-3).point) < 0) {
//                sumScore.setText(Integer.toString(sum));
//                score1.setText("");
//                score2.setText("");
//                score3.setText("");
//            } else {
//                sum = sum - (points.get(size - 1).point + points.get(size - 2).point + points.get(size - 3).point);
//                sumScore.setText(Integer.toString(sum));
//            }
//        }

        if (size2 % 3 == 1) {

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

                //score1.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                if (points.get(points.size() - 1).pre == 'D') {
                    score1.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 2));
                }
                if (points.get(points.size() - 1).pre == 'T') {
                    score1.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint() / 3));
                }
                if (points.get(points.size() - 1).pre == ' ') {
                    score1.setText(points.get(size - 1).getPre() + Integer.toString(points.get(size - 1).getPoint()));
                }

                //if (size2 != 1) {
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
                //}
            } else {
                sumScore.setText(Integer.toString(sum));
                score1.setText("");
                score2.setText("");
                score3.setText("");

//                Point p1 = points.get(size-2);
//                Point p2 = points.get(size-1);
//                points.add(p1);
//                points.add(p2);
                size2 = size2 + 2;
            }
        }

        if (size2 % 3 == 2) {

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

                //if (size2 != 2) {
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
                //}
            } else {
                sumScore.setText(Integer.toString(sum));
                score1.setText("");
                score2.setText("");
                score3.setText("");
                size2 = size2 + 1;
            }
        }

        if (size2 % 3 == 0) {

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

//        for (int i = 0; i < points.size(); i++) {
//            if (i % 3 == 0) {
//                if ((sum - points.get(size-1).point) > 0) {
//                    score1.setText("");
//                    score2.setText("");
//                    score3.setText("");
//                    score1.setText(points.get(i).getPre() + Integer.toString(points.get(i).getPoint()));
//                } else {
//                    sumScore.setText(Integer.toString(sum));
//                    score1.setText("");
//                    score2.setText("");
//                    score3.setText("");
//                }
//            }
//            if (i % 3 == 1) {
//                if (sum - (points.get(size-1).point + points.get(size-2).point) > 0) {
//                    score2.setText(points.get(i).getPre() + Integer.toString(points.get(i).getPoint()));
//                } else {
//                    sumScore.setText(Integer.toString(sum));
//                    score1.setText("");
//                    score2.setText("");
//                    score3.setText("");
//                }
//            }
//            if (i % 3 == 2) {
//                if (sum - (points.get(size-1).point + points.get(size-2).point + points.get(size-3).point) > 0) {
//                    score3.setText(points.get(i).getPre() + Integer.toString(points.get(i).getPoint()));
//                } else {
//                    sumScore.setText(Integer.toString(sum));
//                    score1.setText("");
//                    score2.setText("");
//                    score3.setText("");
//                }
//            }
    }


        public void operator (View v){
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

            if (text.equals("C")) {
                if(size2 > 0) {
                    if (score1.getText() == "" && score2.getText() == "" && score3.getText() == "") {
                        score1.setText(Integer.toString(history.get(history.size() - 3).lastScore));
                        score2.setText(Integer.toString(history.get(history.size() - 2).lastScore));
                        score3.setText(Integer.toString(history.get(history.size() - 1).lastScore));
                        sum = history.get(history.size() - 1).getSum();
                        sumScore.setText(Integer.toString(sum));
                    }
                    if (size2 % 3 == 1 ) {
                        score1.setText("");
                        sum = history.get(history.size() - 1).getSum();
                        sumScore.setText(Integer.toString(sum));
                    }
                    if (size2 % 3 == 2 ) {
                        score2.setText("");
                        sum = history.get(history.size() - 1).getSum();
                        sumScore.setText(Integer.toString(sum));
                    }
                    if (size2 % 3 == 0 ) {
                        score3.setText("");
                        sum = history.get(history.size() - 1).getSum();
                        sumScore.setText(Integer.toString(sum));
                    }

                    history.remove(history.size() - 1);
                    size2 = size2 - 1;
                }
                //points.remove(points.size());
                //sumScore.setText(Integer.toString(sums[sums.length-1]));

            }

        }
}