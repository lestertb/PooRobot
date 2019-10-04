package com.example.amendez.robotvendedor;

public class GameStation extends Article {
    private int cantGames;

    public GameStation(int price, String name, int cant, String seller, String store, int cantGames) {
        super(price, name, cant, seller, store);
        this.cantGames = cantGames;
    }

    public int getCantGames() {
        return cantGames;
    }

    public void setCantGames(int cantGames) {
        this.cantGames = cantGames;
    }
}
