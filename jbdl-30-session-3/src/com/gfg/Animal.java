package com.gfg;

public class Animal extends Lifeform{
    private int weight ;
    public void eat() {
        System.out.println("eating");
    }
    Animal(int weight, int age){
        super(age);
        this.weight =  weight;
    }
    public int getWeight(){
        return this.weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
}
