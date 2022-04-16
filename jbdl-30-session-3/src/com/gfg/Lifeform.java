package com.gfg;

public abstract class Lifeform {
    int age;
    Lifeform(int age){
        this.age = age;
    }
    void breathe(){
        System.out.println("breathes");
    }
    public int getAge(){
        return this.age;
    }
}
