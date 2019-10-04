package com.example.amendez.robotvendedor;

public class Computer extends Article {
    private int cantRam;

    public Computer(int price, String name, int cant, String seller, String store, int cantRam) {
        super(price, name, cant, seller, store);
        this.cantRam = cantRam;
    }

    public int getCantRam() {
        return cantRam;
    }

    public void setCantRam(int cantRam) {
        this.cantRam = cantRam;
    }

}
