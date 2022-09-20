package com.sik.study.cs.cp01.observer;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 11:22
 */
public class Application {
    public static void main(String[] args) {
        Topic topic = new Topic();
        Observer a = new TopicSubscriver("a", topic);
        Observer b = new TopicSubscriver("b", topic);
        Observer c = new TopicSubscriver("c", topic);

        topic.register(a);
        topic.register(b);
        topic.register(c);

        topic.postMessage("postMessage!!");
    }
}
