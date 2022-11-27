package com.sifterstudios.postmanquiz.entities;

public class Item {
    private final Integer id;
    private final int amount;
    private final String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public Item(int id, int amount, String name) {
        this.id = id;
        this.amount = amount;
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        amount = -1;
    }
}
