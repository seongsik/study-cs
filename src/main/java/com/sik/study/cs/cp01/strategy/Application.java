package com.sik.study.cs.cp01.strategy;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 11:15
 */
public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Item A = new Item("itemA", 100);
        Item B = new Item("itemB", 100);

        cart.addItem(A);
        cart.addItem(B);

        cart.pay(new CardOneStrategy("name", "card-number", "123", "12/01"));
        cart.pay(new CardTwoStrategy("email@email.com", "1234"));


    }
}
