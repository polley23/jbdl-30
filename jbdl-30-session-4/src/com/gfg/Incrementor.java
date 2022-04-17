package com.gfg;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Incrementor {
    Integer a ;
    //Integer maxVal;
   // ReentrantLock  lock;

    public Incrementor() {
        this.a = new Integer(0);
        //this.lock = new ReentrantLock();
    }

    synchronized void  increment(){
       // lock.lock();
        a++;
       // lock.unlock();
    }
}
