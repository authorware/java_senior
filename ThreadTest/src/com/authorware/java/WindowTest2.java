package com.authorware.java;

/**
 * @ Author Simon Zhang
 * @ Date 2021/6/8 15:22
 * @ Version 1.0.0
 */
class Window2 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {

        while (true){
            synchronized (Window2.class) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(getName() + "卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
