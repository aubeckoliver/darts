package com.example.dartsscorer;

public class Point {

    char pre;
    int point;
    int multipliedPoint;

    public int getMultipliedPoint() {
        return multipliedPoint;
    }

    public void setMultipliedPoint(int multipliedPoint) {
        this.multipliedPoint = multipliedPoint;
    }


    public Point(char pre, int point) {
        this.pre = pre;
        this.point = point;
    }


    public char getPre() {
        return pre;
    }

    public void setPre(char pre) {
        this.pre = pre;
    }


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}


