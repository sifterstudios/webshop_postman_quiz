package com.sifterstudios.postmanquiz.part5;

import com.sifterstudios.postmanquiz.entities.Item;
import com.sifterstudios.postmanquiz.part4.PaymentType;

import java.util.List;

public class CartTwo {
    public static CartTwo sCart = new CartTwo();
    private List<Item> cart;
    private int totalPrice;
    private int numberOfItems;
    private PaymentType preferedPaymentType;

    public CartTwo() {
        cart = List.of(
                new Item(5345, 5, "Banan", "Bama", 8),
                new Item(753, 1, "Hals-drops", "Fribol", 89));
        int total = cart.stream()
                .mapToInt(item -> (item.getPricePerUnit() * item.getAmount()))
                .sum();
        totalPrice = total;
        numberOfItems = cart.stream()
                .mapToInt(Item::getAmount)
                .sum();
        preferedPaymentType = PaymentType.CARD;
    }

    public List<Item> getCart() {
        return cart;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public PaymentType getPreferedPaymentType() {
        return preferedPaymentType;
    }

    public void setPreferedPaymentType(PaymentType preferedPaymentType) {
        this.preferedPaymentType = preferedPaymentType;
    }

    public void addToCart(Item item) {
        cart.add(item);
    }

    public void removeFromCart(Item item) {
        cart.remove(item);
    }
}
