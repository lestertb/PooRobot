package com.example.amendez.robotvendedor;


public class Article {

    private int price;
    private String name;
    private int cant;
    private String seller;
    private String store;

    public Article(int price, String name, int cant, String seller, String store) {
        this.price = price;
        this.name = name;
        this.cant = cant;
        this.seller = seller;
        this.store = store;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }


}
