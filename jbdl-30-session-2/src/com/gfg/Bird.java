package com.gfg;

public class Bird extends Animal {

    Bird(int weight,int age ) {
        super(weight,age);
    }
    public  void fly(){
        System.out.println("flying");
    }
    public void eat(){
        System.out.println("bird is eating");

    }

}
