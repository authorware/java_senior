package com.authorware.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Simon Zhang
 * @Date 2021/6/25 10:15 下午
 * @Version 1.0
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadPool
{
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(5);
        //适合Runnable
        service.execute(new NumberThread());
        service.execute(new NumberThread1());
//        service.submit();//适合Callable
        //关闭线程池
        service.shutdown();
    }
}
