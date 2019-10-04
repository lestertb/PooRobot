package com.example.amendez.robotvendedor;

public class Bottle extends Article {

    private String material;

    public Bottle(int price, String name, int cant, String seller, String store, String material) {
        super(price, name, cant, seller, store);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


}
