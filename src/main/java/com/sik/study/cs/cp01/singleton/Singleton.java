package com.sik.study.cs.cp01.singleton;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:15
 */
public class Singleton {
    private static class singleInstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static synchronized Singleton getInstance() {
        return singleInstanceHolder.INSTANCE;
    }
}
