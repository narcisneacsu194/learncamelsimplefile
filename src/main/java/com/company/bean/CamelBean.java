package com.company.bean;

public class CamelBean {
    public String map(String input){
        System.out.println("Inside map method.");
        return input.replace(",", "*");
    }

    public String map1(String input){
        System.out.println("Inside map1 method.");
        return input.replace(",", "*");
    }
}
