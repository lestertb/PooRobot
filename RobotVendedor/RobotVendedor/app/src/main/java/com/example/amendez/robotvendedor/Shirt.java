package com.example.amendez.robotvendedor;

public class Shirt extends Article {

    private String type;

    public Shirt(int price, String name, int cant, String seller, String store, String type) {
        super(price, name, cant, seller, store);
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
