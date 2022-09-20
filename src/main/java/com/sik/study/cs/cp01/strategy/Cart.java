package com.sik.study.cs.cp01.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:53
 */
public class Cart {
    List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public int calculateTotal() {
        return items.stream().filter(o -> o.getPrice() > 0).mapToInt(Item::getPrice).sum();
    }

    public void pay(PaymentStrategy paymentStrategy) {
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}
