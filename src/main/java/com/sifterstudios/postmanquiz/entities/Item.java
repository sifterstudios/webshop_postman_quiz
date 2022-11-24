package com.sifterstudios.postmanquiz.entities;

public class Item {
    private final int id;
    private final int amount;

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public Item(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
