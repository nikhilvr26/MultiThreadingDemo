package com.multithreading.oddAndEven;

public class OddAndEvenMain {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new ThreadOdd(lock, 10));
        Thread t2 = new Thread(new ThreadEven(lock, 10));
        t1.start();
        t2.start();
    }
}
