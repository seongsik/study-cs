package com.sik.study.cs.cp01.strategy;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:51
 */
public class CardTwoStrategy implements PaymentStrategy{
    private String emailId;
    private String password;

    public CardTwoStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid by CardTwo");
    }
}
