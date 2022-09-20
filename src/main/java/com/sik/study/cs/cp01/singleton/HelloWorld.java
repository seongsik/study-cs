package com.sik.study.cs.cp01.singleton;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:15
 */
public class HelloWorld {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
