package com.gfg;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Random random = new Random();// no arg consturctor
//        Power power = new PowerByLib();
//        Calculator calculator =
//                new Calculator(random.nextInt(100),random.nextInt(10),power);
//        System.out.println(calculator.getPower());
//        Lifeform lifeform = new Dog(10,20);
//        System.out.println(new AgeFinder(lifeform).getAge());
        Set<Review> set = new TreeSet<>(new UserReviewComp());
        for(int i =0;i<100;i++){
            set.add(new Review(random.nextInt(5),random.nextInt(5)));
        }
        print(set);

    }

    static void print(Collection<Review> collection){
        for(Review i : collection){
            System.out.println(i.criticReview + " "+ i.userReview + " ");
            //collection.remove(i);
        }

    }
}

