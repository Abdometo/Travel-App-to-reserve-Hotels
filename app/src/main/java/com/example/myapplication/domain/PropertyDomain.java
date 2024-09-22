package com.example.myapplication.domain;

import java.io.Serializable;

public class PropertyDomain implements Serializable {

    // Variables
    private String title;
    private String type;
    private String address;
    private String description;
    private String picPath;
    private int price;
    private int bed;
    private int bath;
    private int size;
    private boolean garage;
    private double score;

    // Constructor


    public PropertyDomain( String type,String title, String address, String picPath, int price, int bed, int bath, int size, boolean garage, double score, String description) {
        this.title = title;
        this.type = type;
        this.address = address;
        this.description = description;
        this.picPath = picPath;
        this.price = price;
        this.bed = bed;
        this.bath = bath;
        this.size = size;
        this.garage = garage;
        this.score = score;
    }


    // getter

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getPicPath() {
        return picPath;
    }

    public int getPrice() {
        return price;
    }

    public int getBed() {
        return bed;
    }

    public int getBath() {
        return bath;
    }

    public int getSize() {
        return size;
    }

    public boolean isGarage() {
        return garage;
    }

    public double getScore() {
        return score;
    }

    // setter


    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
