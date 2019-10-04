package com.example.amendez.robotvendedor;

public class Checkout {
    private int idClient;
    private int idCheckout;
    private String postalCode;

    public Checkout(int idClient, int idCheckout, String postalCode) {
        this.idClient = idClient;
        this.idCheckout = idCheckout;
        this.postalCode = postalCode;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdCheckout() {
        return idCheckout;
    }

    public void setIdCheckout(int idCheckout) {
        this.idCheckout = idCheckout;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
