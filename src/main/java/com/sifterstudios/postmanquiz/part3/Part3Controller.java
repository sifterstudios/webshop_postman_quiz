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
    public List<Item> getItemPageOfSize(@RequestParam int page, @RequestParam int pageSize) throws ServerException {
        var items = new ArrayList<Item>();
        int totalItems = ItemDataBase.items.size();
        int startNumber = page * pageSize;
        if (startNumber + pageSize >= totalItems) {
            throw new ServerException("Item count exceeded. There are " + totalItems + " items in the database");
        }

        for (int i = 0; i < pageSize; i++) {
            items.add(ItemDataBase.items.getItemById(startNumber + i));
        }
        return items;
    }


}
