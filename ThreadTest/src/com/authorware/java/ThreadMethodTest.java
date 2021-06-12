package com.authorware.java;

/**
 * 测试Thread类中常用方法
 * @ Author Simon Zhang
 * @ Date 2021/3/18 10:32
 * @ Version 1.0.0
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + i);
            }
            if (i % 20 == 0)
                this.yield();
        }
    }

    public HelloThread() {
        super();
    }

    public HelloThread(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public ThreadMethodTest() {
        super();
    }

    public static void main(String[] args) throws InterruptedException {
        HelloThread t1 = new HelloThread("线程二");
//        t1.setName("线程一");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println("shijian");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + i);
            }
            if (i == 20){
                try {
                    t1.join();
                    System.out.println("hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t1.isAlive());
    }
}
