package com.sifterstudios.postmanquiz.entities;

import java.util.List;
public final class ItemDataBase {

    public static ItemDataBase items = new ItemDataBase();
    private List<Item> itemList;

    public ItemDataBase() {
        itemList = List.of(
                new Item(0),
                new Item(1),
                new Item(2),
                new Item(3),
                new Item(4),
                new Item(5),
                new Item(6),
                new Item(7),
                new Item(8),
                new Item(9),
                new Item(10),
                new Item(11));
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
