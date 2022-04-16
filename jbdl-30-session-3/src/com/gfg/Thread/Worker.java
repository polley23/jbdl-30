package com.gfg.Thread;

public class Worker implements Runnable{
    Task task;

    public Worker(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.doSomething();
    }
}
