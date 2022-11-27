package com.sifterstudios.postmanquiz.part2;

import com.sifterstudios.postmanquiz.entities.Cart;
import com.sifterstudios.postmanquiz.entities.Item;
import com.sifterstudios.postmanquiz.entities.ItemDataBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
public class Part2Controller {
    @GetMapping("api/v1/items")
    public List<Item> getAllItems() {
        assert ItemDataBase.items != null;
        return List.of(
                ItemDataBase.items.getItemById(0),
                ItemDataBase.items.getItemById(1),
                ItemDataBase.items.getItemById(2),
                ItemDataBase.items.getItemById(3)
        );
    }

    @GetMapping("api/v1/cart")
    public List<Item> getCart() {
        return Cart.WebShopCart.get();
    }

    @PostMapping(path = "api/v1/items", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addItemToCart(@RequestBody Item item) throws ServerException {
        if (item == null) throw new ServerException("Could not find item");
        Cart.WebShopCart.add(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping(path = "api/v1/items/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteItemFromCart(@RequestBody Item item, @PathVariable int id) throws ServerException {
        if (item == null) throw new ServerException("Could not find item");
        Cart.WebShopCart.remove(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
