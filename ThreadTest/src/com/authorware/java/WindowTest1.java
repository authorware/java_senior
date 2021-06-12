package com.authorware.java;

/**
 * @ Author Simon Zhang
 * @ Date 2021/6/7 22:34
 * @ Version 1.0.0
 */
class Window1 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized(this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 W = new Window1();

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
