package com.company;

public class Main {

    public static void main(String[] args) {
        ITelephone anhsPhone = new DeskPhone(123456);
        anhsPhone.powerOn();
        anhsPhone.callPhone(123456);
        anhsPhone.answer();


        anhsPhone = new MobilePhone(23456);
        anhsPhone.powerOn();
        anhsPhone.callPhone(23456);
        anhsPhone.answer();
    }
}
