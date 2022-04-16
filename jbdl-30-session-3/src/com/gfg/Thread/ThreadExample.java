package com.gfg.Thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {
    Worker worker;

    public ThreadExample(Worker worker) {
        this.worker = worker;
    }

    public void execute(){
//        Thread thread  = new Thread(worker);
//        thread.start();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<Runnable> tasks = new ArrayList<>();
        for(int i = 0;i<1000;i++){
            tasks.add(new Worker(new PrintOddNumber()));
            executorService.submit(tasks.get(i));
        }

    }

}
