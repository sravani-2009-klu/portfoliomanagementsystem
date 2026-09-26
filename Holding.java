package com.portfolioproject.model;

public class Holding {

    private String holdingId;
    private Asset asset;
    private int quantity;

    // Default constructor - required for Jackson
    public Holding() {
    }

    // Parameterized constructor
    public Holding(String holdingId, Asset asset, int quantity) {
        this.holdingId = holdingId;
        this.asset = asset;
        this.quantity = quantity;
    }

    // Getters
    public String getHoldingId() {
        return holdingId;
    }

    public Asset getAsset() {
        return asset;
    }

    public int getQuantity() {
        return quantity;                                                                         
        
        return "Holding{" +
                "Holding ID='" + holdingId + '\'' +
                ", Asset=" + asset +
                ", Quantity=" + quantity +
                ", Current Value=" + getCurrentValue() +
                '}';
    }
}