package com.sik.study.cs.cp01.strategy;

/**
 * Created by sik371@ktnet.co.kr 2022-09-20 AM 10:51
 */
public class CardOneStrategy implements PaymentStrategy{
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CardOneStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid by CardOne");
    }
}
