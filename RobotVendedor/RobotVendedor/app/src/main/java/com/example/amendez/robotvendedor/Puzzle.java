package com.example.amendez.robotvendedor;

public class Puzzle extends Article {

    private int pieces;

    public Puzzle(int price, String name, int cant, String seller, String store, int pieces) {
        super(price, name, cant, seller, store);
        this.pieces = pieces;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

}
