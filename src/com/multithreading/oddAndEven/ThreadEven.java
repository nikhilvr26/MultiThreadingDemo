package com.multithreading.oddAndEven;

public class ThreadEven implements Runnable{

    private Object lock;
    private int max;

    public ThreadEven(Object lock, int max) {
        this.lock = lock;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=0; i<=max; i++){
            synchronized (lock){
                if(i%2 == 0){
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
