package com.example.dartsscorer;

public class History {

    int lastScore;
    int sum;
    int sum2;
    int sum3;
    int sum4;

    public History(int lastScore, int sum, int sum2, int sum3, int sum4) {
        this.lastScore = lastScore;
        this.sum = sum;
        this.sum2 = sum2;
        this.sum3 = sum3;
        this.sum4 = sum4;
    }


    public History(int lastScore, int sum, int sum2, int sum3) {
        this.lastScore = lastScore;
        this.sum = sum;
        this.sum2 = sum2;
        this.sum3 = sum3;
    }



    public int getSum3() {
        return sum3;
    }

    public void setSum3(int sum3) {
        this.sum3 = sum3;
    }

    public int getSum4() {
        return sum4;
    }

    public void setSum4(int sum4) {
        this.sum4 = sum4;
    }

    public int getSum2() {
        return sum2;
    }

    public void setSum2(int sum2) {
        this.sum2 = sum2;
    }


    public History(int lastScore, int sum) {
        this.lastScore = lastScore;
        this.sum = sum;
    }

    public History(int lastScore, int sum, int sum2) {
        this.lastScore = lastScore;
        this.sum = sum;
        this.sum2 = sum2;
    }

    public int getLastScore() {
        return lastScore;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }








}
