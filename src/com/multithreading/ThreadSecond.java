package com.multithreading;

public class ThreadSecond implements Runnable{

    private Object lock;
    private int max;

    public ThreadSecond(Object lock, int max){
        this.lock = lock;
        this.max = max;
    }

    @Override
    public void run() {
        for (char ch = 'a'; ch <= 'a' + max; ch++) {
            synchronized (lock) {
                System.out.print(ch + " ");
                lock.notify();
                if (ch != max) {
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
