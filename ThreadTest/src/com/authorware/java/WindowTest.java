package com.authorware.java;

/**
 * 创建三个窗口卖票，总票数100张
 * @ Author Simon Zhang
 * @ Date 2021/6/7 22:02
 * @ Version 1.0.0
 */
class Windows extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {

        while (true){
            if (ticket > 0) {
                System.out.println(getName() + "卖票，票号为" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Windows t1 = new Windows();
        Windows t2 = new Windows();
        Windows t3 = new Windows();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
