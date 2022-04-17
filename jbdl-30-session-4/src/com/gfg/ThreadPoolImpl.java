package com.gfg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolImpl implements ThreadPool {

    private Queue<Runnable> queue;
    private Thread[] workers;
    private ReentrantLock lock;

    public ThreadPoolImpl(int count) {
        workers = new Thread[count];
        lock = new ReentrantLock();
        this.queue =  new LinkedList<>();
        for(int i=0;i<count;i++){
            Thread t = new Thread(new Worker());
            t.start();
            workers[i] =t;

        }
        
    }

    @Override
    public void submit(Runnable runnable) {
        lock.lock();
        queue.add(runnable);
        lock.unlock();

    }

    @Override
    public void shutDown() {
        for(Thread worker : workers){
            worker.stop();
        }
    }


    class Worker implements Runnable{
        Worker(){

        }
        @Override
        public void run() {

            while(true) {
                lock.lock();
                if(!queue.isEmpty()) {
                    Runnable runnable = queue.poll();
                    runnable.run();
                    lock.unlock();
                }else{
                    lock.unlock();
                }

            }

        }
    }
}
