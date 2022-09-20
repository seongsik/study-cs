package com.sik.study.cs.cp01.factory;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:40
 */
public class HelloWorld {
    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee americano = CoffeeFactory.getCoffee("Americano", 3000);
        System.out.println("Factory Latte :: " + latte);
        System.out.println("Factory Americano :: " + americano);
    }
}
