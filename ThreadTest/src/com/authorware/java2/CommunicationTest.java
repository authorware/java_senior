package com.authorware.java2;

import javax.xml.bind.SchemaOutputResolver;

/**
 * 线程通信三个方法：wait()一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify()一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级最高的那个
 * notifyAll()一旦执行此方法，就会唤醒被wait的所有线程
 * 说明：
 * 1.这三个方法必须使用在同步代码块或同步方法中
 * 2.三个方法的调用者必须是同步代码块或者同步方法中的同步监视器。否则会出现异常。
 * 3.wait() notify() notifyAll() 三个方法是定义在java.lang.Object类中。
 *
 * @Author Simon Zhang
 * @Date 2021/6/21 8:37 下午
 * @Version 1.0
 */
class Number implements Runnable{
    private int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                obj.notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
