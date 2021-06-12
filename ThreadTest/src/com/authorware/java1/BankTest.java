package com.authorware.java1;

/**
 * 使用同步机制将单例中的懒汉模式修改为线程安全的
 * @ Author Simon Zhang
 * @ Date 2021/6/8 16:03
 * @ Version 1.0.0
 */
public class BankTest {
}

class Bank{
    private Bank(){}
    private static Bank instance = null;

    public static Bank getInstance(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if (instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }
        if (instance == null){
            synchronized (Bank.class){
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}