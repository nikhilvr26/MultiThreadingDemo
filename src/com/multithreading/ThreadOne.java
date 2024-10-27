package com.multithreading;

public class ThreadOne extends Thread{
    private Object lock;
    private int max;

    public ThreadOne(Object lock, int max){
        this.lock = lock;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=0; i<=max; i++){
            synchronized (lock){
                System.out.print(i+ " ");
                lock.notify();
                if(i!=max){
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
