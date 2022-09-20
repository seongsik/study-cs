package com.sik.study.cs.cp01.factory;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:40
 */
public class Americano extends Coffee {
    private int price;
    public Americano(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
