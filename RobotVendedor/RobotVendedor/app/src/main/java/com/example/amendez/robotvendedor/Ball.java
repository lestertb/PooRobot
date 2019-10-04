package com.example.amendez.robotvendedor;

public class Ball extends Article {

    private String size;


    public Ball(int price, String name, int cant, String seller, String store, String size) {
        super(price, name, cant, seller, store);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



}
