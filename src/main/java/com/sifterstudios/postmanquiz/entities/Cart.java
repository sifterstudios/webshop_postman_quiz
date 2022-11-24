package com.sifterstudios.postmanquiz.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static Cart WebShopCart = new Cart();

    private List<Item> allItems;

    public Cart() {
        allItems = new ArrayList<>();
    }

    public List<Item> get() {
        return allItems;
    }

    public void add(Item item) {
        allItems.add(item);
    }

    public void remove(Item item) {
        allItems.remove(item);
    }
}
