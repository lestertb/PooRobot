package com.example.amendez.robotvendedor;

public class Cellphone extends Article {

    private String brand;

    public Cellphone(int price, String name, int cant, String seller, String store, String brand) {
        super(price, name, cant, seller, store);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
