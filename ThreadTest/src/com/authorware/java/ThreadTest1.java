package com.authorware.java;

/**
 * @ Author Simon Zhang
 * @ Date 2021/6/7 22:24
 * @ Version 1.0.0
 */
class MThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.setName("线程一");
        t1.start();

        Thread t2 = new Thread(mThread);
        t2.setName("线程二");
        t2.start();
    }
}
