package com.authorware.java;

/**
 * @ Author Simon Zhang
 * @ Date 2021/6/8 15:46
 * @ Version 1.0.0
 */
class Window4 extends Thread {
    private static int ticket = 100;


    @Override
    public void run() {

        while (true){
            show();
            }
        }

    public static synchronized void show() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

