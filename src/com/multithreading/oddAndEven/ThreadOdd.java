package com.multithreading.oddAndEven;

import java.util.concurrent.locks.Lock;

public class ThreadOdd implements Runnable {

    private Object lock;
    private int max;

    public ThreadOdd(Object lock, int max){
        this.lock = lock;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=0; i<=max; i++){
            synchronized (lock) {
                if (i % 2 == 1) {
                    System.out.println(i);
                }
                lock.notify();
                if(i != max){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
