package com.sifterstudios.postmanquiz.entities;

import java.util.List;
public final class ItemDataBase {

    public static ItemDataBase items = new ItemDataBase();
    private final List<Item> itemList;

    public ItemDataBase() {
        itemList = List.of(
                new Item(0, "Potato"),
                new Item(1, "Sausage"),
                new Item(2, "Carrot"),
                new Item(3, "Tomato"),
                new Item(4, "Apple"),
                new Item(5, "Pear"),
                new Item(6, "Peach"),
                new Item(7, "Cabbage"),
                new Item(8, "Beans"),
                new Item(9, "Peas"),
                new Item(10,"Peanuts"),
                new Item(11,"Mushroom"));
        System.out.println("Created Item Database");
    }

    public Item getItemById(int id) {
        try {
            return itemList.get(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public int size() {
        return itemList.size();
    }
}
