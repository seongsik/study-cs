package com.sik.study.cs.cp01.factory;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:39
 */
public class CoffeeFactory {
    public static Coffee getCoffee(String type, int price) {
        if("Latte".equalsIgnoreCase(type)) {
            return new Latte(price);
        } else if("Americano".equalsIgnoreCase(type)) {
            return new Americano(price);
        } else {
            return new DefaultCoffee(price);
        }
    }
}
