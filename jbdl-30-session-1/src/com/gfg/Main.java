package com.gfg;


import com.gfg.calculator.Calculator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Random random = new Random();// no arg consturctor
//        Calculator calculator = new Calculator(random.nextInt(), random.nextInt()); // all-arg
//        System.out.print(calculator.getSum());
        Bird bird = new Bird(random.nextInt(100));
        //bird.eat();// bird is eating
        Animal animal = new Animal(random.nextInt(100));
        //animal.eat();// eating;
        Dog dog = new Dog(random.nextInt(100));
        Feeder feeder = new Feeder();
        feeder.feeds(bird);
        feeder.feeds(animal);
        feeder.feeds(dog);
    }
}
