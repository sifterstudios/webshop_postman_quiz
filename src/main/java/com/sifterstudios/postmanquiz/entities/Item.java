package com.sifterstudios.postmanquiz.entities;

public class Item {
    private final Integer id;
    private final int amount;
    private final String name;

    private final String brand;
    private final int pricePerUnit;

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getBrand() {
        return brand;
    }

    public Item(int id, int amount, String name, String brand, int pricePerUnit) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.brand = brand;
        this.pricePerUnit = pricePerUnit;
    }

    public Item(int id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        amount = -1;
        pricePerUnit = 0;
    }
}
