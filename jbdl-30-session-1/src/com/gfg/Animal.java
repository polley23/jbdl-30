package com.gfg;

public class Animal {
    private int weight ;
    public void eat() {
        System.out.println("eating");
    }
    Animal(int weight){
        this.weight =  weight;
    }
    public int getWeight(){
        return this.weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
}
