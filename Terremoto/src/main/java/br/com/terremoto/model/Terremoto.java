package br.com.terremoto.model;

import java.util.Date;

public class Terremoto {
    private String local;
    private double magnitude;
    private Date data;
    private double latitude;
    private double longitude;

    public Terremoto(String local, double magnitude, Date data, double latitude, double longitude) {
        this.local = local;
        this.magnitude = magnitude;
        this.data = data;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLocal() { return local; }
    public double getMagnitude() { return magnitude; }
    public Date getData() { return data; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    @Override
    public String toString() {
        return "Local: " + local + ", Magnitude: " + magnitude + ", Data: " + data;
    }
}

