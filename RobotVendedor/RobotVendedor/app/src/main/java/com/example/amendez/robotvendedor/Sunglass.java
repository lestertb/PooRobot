package com.example.amendez.robotvendedor;

public class Sunglass extends Article {
    private String material;

    public Sunglass(int price, String name, int cant, String seller, String store, String material) {
        super(price, name, cant, seller, store);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
