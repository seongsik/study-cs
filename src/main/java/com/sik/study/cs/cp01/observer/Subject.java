package com.sik.study.cs.cp01.observer;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 11:23
 */
public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers();
    public Object getUpdate(Observer observer);
}
