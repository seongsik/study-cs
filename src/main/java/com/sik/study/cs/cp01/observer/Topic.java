package com.sik.study.cs.cp01.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 11:24
 */
public class Topic implements Subject{
    private List<Observer> observers;
    private String message;

    public Topic() {
        this.observers = new ArrayList<>();
        this.message = "";
    }



    @Override
    public void register(Observer observer) {
        if(!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message sended to Topic : " + msg);
        this.message = msg;
        notifyObservers();
    }
}
