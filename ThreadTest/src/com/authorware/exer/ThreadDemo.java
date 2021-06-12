package com.authorware.exer;

/**
 * 创建两个分线程
 * @ Author Simon Zhang
 * @ Date 2021/3/18 9:56
 * @ Version 1.0.0
 */
public class ThreadDemo {
    public static void main(String[] args) {

//        MyThread1 m1 = new MyThread1();
//        MyThread2 m2 = new MyThread2();

//        m1.start();
//        m2.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }

            }
        }.start();
    }
}


class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
