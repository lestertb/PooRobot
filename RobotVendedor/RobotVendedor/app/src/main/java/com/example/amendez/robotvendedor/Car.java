package com.example.amendez.robotvendedor;

public class Car extends Article {
    private String color;

    public Car(int price, String name, int cant, String seller, String store, String color) {
        super(price, name, cant, seller, store);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
