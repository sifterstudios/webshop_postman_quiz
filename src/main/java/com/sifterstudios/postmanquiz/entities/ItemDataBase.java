package com.sifterstudios.postmanquiz.entities;

import java.util.List;
import java.util.stream.Collector;

public final class ItemDataBase  {

    public static ItemDataBase items = new ItemDataBase();
    private final List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public ItemDataBase() {
        itemList = List.of(
                new Item(0, "Potato", "Scan"),
                new Item(1, "Sausage", "Google"),
                new Item(2, "Carrot", "Apple"),
                new Item(3, "Tomato", "Amazon"),
                new Item(4, "Apple", "Microsoft"),
                new Item(5, "Pear", "Tencent"),
                new Item(6, "Peach", "Facebook"),
                new Item(7, "Cabbage", "Visa"),
                new Item(8, "Beans", "McDonald's"),
                new Item(9, "Peas", "Alibaba"),
                new Item(10,"Peanuts", "AT&T"),
                new Item(11,"Mushroom", "IBM"));
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
