package com.sifterstudios.postmanquiz.part2;

import com.sifterstudios.postmanquiz.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Part2Controller {
    @GetMapping("api/v1/items")
    public List<Item> getAllItems() {
        return List.of(
                new Item("Item1"),
                new Item("Item2"),
                new Item("Item3"),
                new Item("Item4")
        );
    }
}