package com.sik.study.cs.cp01.strategy;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:53
 */
public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
