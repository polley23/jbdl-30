package com.gfg;

public interface ThreadPool {
    void submit(Runnable runnable);
    void shutDown();
}
