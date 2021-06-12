package com.authorware.java;

/**
 * @ Author Simon Zhang
 * @ Date 2021/6/8 15:41
 * @ Version 1.0.0
 */
class Window3 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 W = new Window3();

        Thread t1 = new Thread(W);
        Thread t2 = new Thread(W);
        Thread t3 = new Thread(W);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}