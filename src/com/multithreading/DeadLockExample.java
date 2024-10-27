package com.multithreading;

public class DeadLockExample {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread t1 = new Thread(()->{
            synchronized (lock1){
                System.out.println("Thread 1 is holding lock1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            System.out.println("Thread 1 trying to acquire lock2");
            synchronized (lock2){
                System.out.println("Thread 1 acquired lock2");
            }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lock2) {
                System.out.println("Thread 2 holding lock2");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 2 trying to acquire lock1");
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1");
                }
            }
        });
        t1.start();
        t2.start();

    }
}
