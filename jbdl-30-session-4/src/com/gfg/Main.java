package com.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i =0;i<10;i++){
//                    if(i==5){
//                       Thread.yield();
//                    }
//                    System.out.println(Thread.currentThread().getName() + " "+ i);
//
//                }
//
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Happy Coding");
//            }
//        });
//
//        thread1.setPriority(Thread.MAX_PRIORITY);
//        thread2.setPriority(Thread.MIN_PRIORITY);
//
//        thread1.start();
//        thread2.start();

        //thread1 -> 0,2,4,6...
        //thread2 -> 1,3,5,7...
        //output-> 0,1,2,3,4,5,6...
        OddEvenPrinter oddEvenPrinter =  new OddEvenPrinter(500000);
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                oddEvenPrinter.printOdd();
//            }
//        }, "Odd Thread");
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                oddEvenPrinter.printEven();
//            }
//        }, "Even Thread");
//
//        thread1.start();
//        thread2.start();

//        Incrementor incrementor = new Incrementor();
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        for(int i = 0; i<100000;i++){
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    incrementor.increment();
//                }
//            });
//        }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(incrementor.a);
 // impl of own thread pool
        Incrementor incrementor = new Incrementor();
        ThreadPool executorService = new ThreadPoolImpl(100);
        for(int i = 0; i<100000;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    incrementor.increment();
                }
            });
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(incrementor.a);
        executorService.shutDown();

    }
    /*
    Political washroom :
    there is a washroom is of capacity 3 or N
    there are two political parties. Democrats and Republicans
    At a time people from same political party should be there in the washroom.
     */
}
