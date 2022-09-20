package com.sik.study.cs.cp01.observer;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 11:26
 */
public class TopicSubscriver implements Observer{
    private String name;
    private Subject topic;

    public TopicSubscriver(String name, Subject topic) {
        this.name = name;
        this.topic = topic;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        System.out.println(name + " :: got Message : " + msg);
    }
}
