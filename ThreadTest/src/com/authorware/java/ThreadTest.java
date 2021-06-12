package com.authorware.java;

/**
 * 多线程的创建
 * @ Author Simon Zhang
 * @ Date 2021/3/18 9:07
 * @ Version 1.0.0
 */
class MyThread extends Thread{

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }
        System.out.println("HELLO");
    }
}
