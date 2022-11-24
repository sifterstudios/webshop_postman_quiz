package com.sifterstudios.postmanquiz.part2;

import com.sifterstudios.postmanquiz.entities.Cart;
import com.sifterstudios.postmanquiz.entities.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
public class Part2Controller {
    @GetMapping("api/v1/items")
    public List<Item> getAllItems() {
        return List.of(
                new Item(0,1),
                new Item(1,1),
                new Item(2,1),
                new Item(3,1)
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
