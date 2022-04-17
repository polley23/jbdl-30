package com.gfg;

public class OddEvenPrinter {
    private Integer a;
    private Integer MAX_LIMIT;

    public OddEvenPrinter(Integer MAX_LIMIT) {
        this.a = 0;
        this.MAX_LIMIT = MAX_LIMIT;
    }

    void printOdd(){
        synchronized (this) {
            while (a < MAX_LIMIT) {
                if (a % 2 == 1) {
                    System.out.println(Thread.currentThread().getName()
                            + " " + a);
                    a++;
                    this.notify();
                }else{
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    void printEven(){
        synchronized (this) {
            while (a < MAX_LIMIT) {
                if (a % 2 == 0) {
                    System.out.println(Thread.currentThread().getName()
                            + " " + a);
                    a++;
                    this.notify();
                }else{
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
