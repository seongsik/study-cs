package com.sik.study.cs.cp01.factory;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:38
 */
abstract class Coffee {
    public abstract int getPrice();

    @Override
    public String toString() {
        return "coffee is : " + this.getPrice();
    }
}
