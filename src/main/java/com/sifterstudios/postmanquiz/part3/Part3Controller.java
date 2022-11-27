package com.sifterstudios.postmanquiz.part3;

import com.sifterstudios.postmanquiz.entities.Item;
import com.sifterstudios.postmanquiz.entities.ItemDataBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Part3Controller {

    @GetMapping("/api/v2/items/{id}")
    public Item getItemDetails(@PathVariable int id) throws ServerException {
        if (ItemDataBase.items.getItemById(id) == null) {
            throw new ServerException("No item with id " + id + " found!");
        }
        return ItemDataBase.items.getItemById(id);
    }

    @GetMapping("/api/v2/items")
    public List<Item> getItemPageOfSize(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand) throws ServerException {
        var items = new ArrayList<Item>();

        if (name == null) name = "";
        items.addAll( getQueriedItems(name));

        if (brand != null) {
            items = (ArrayList<Item>) getItemsOfBrand(brand, items);
        }

        if (page == null) page = 0;
        if (pageSize == null) pageSize = 10;


        return getPageOfItems(page, pageSize, items);


    }

    private List<Item> getItemsOfBrand(String brand, ArrayList<Item> items) {
        var brandItems = new ArrayList<Item>();
        for (Item item : items) {
            if (item.getBrand().toLowerCase().equals(brand.toLowerCase())) {
                brandItems.add(item);
            }
        }

        return brandItems;
    }

    private static ArrayList<Item> getQueriedItems(String name) {
        var allItems = new ArrayList<String>();
        var foundItems = new ArrayList<Item>();
        for (int i = 0; i < ItemDataBase.items.size(); i++) {
            allItems.add(ItemDataBase.items.getItemById(i).getName().toLowerCase());
        }
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).equals(name.toLowerCase())) {
                foundItems.add(ItemDataBase.items.getItemById(i));
            }
        }
        if (foundItems.isEmpty()) foundItems.addAll(ItemDataBase.items.getItemList());
        return foundItems;
    }

    private static ArrayList<Item> getPageOfItems(Integer page, Integer pageSize, ArrayList<Item> items) throws ServerException {
        var pageOfItems = new ArrayList<Item>();
        int totalItems = items.size();
        int startNumber = page * pageSize;
        int endNumber = startNumber + pageSize;
        if (endNumber > totalItems) endNumber = totalItems;

        for (int i = startNumber; i < endNumber; i++) {
            pageOfItems.add(items.get(i));
        }
        return pageOfItems;
    }


}
