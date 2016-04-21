package com.example.andresandreamarcos.apptemblores;

/**
 * Created by andrea on 30/3/16.
 */
public class Terremoto {
    private double mag;
    private String place;
    private double x, y;

    public Terremoto(double mag, String place, double x, double y){
        this.mag = mag;
        this.place = place;
        this.x = x;
        this.y = y;
    }
    public double getMag() {
        return mag;
    }

    public void setMag(Double mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
