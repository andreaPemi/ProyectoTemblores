package com.example.andresandreamarcos.apptemblores;

/**
 * Created by andrea on 30/3/16.
 */
public class Terremoto {
    private Double mag;
    private String place;
    private Double coordinates;

    public Terremoto(Double mag, String place, Double coordinates){
        this.mag = mag;
        this.place = place;
        this.coordinates = coordinates;
    }
    public Double getMag() {
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

    public Double getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double coordinates) {
        this.coordinates = coordinates;
    }
}
