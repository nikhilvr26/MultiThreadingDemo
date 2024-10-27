package com.multithreading;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadOne t1 = new ThreadOne(lock, 10);
        Thread t2 = new Thread(new ThreadSecond(lock, 10));
        t1.start();
        t2.start();
    }
}