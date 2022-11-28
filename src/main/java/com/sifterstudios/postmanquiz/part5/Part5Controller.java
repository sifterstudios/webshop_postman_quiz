package com.sifterstudios.postmanquiz.part5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Part5Controller {
    @GetMapping("api/v2/cart")
    public CartTwo getCartTwo() {
        return CartTwo.sCart;
    }
}
