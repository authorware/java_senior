package com.authorware.exer;

import static java.lang.Thread.sleep;

/**
 * @ Author Simon Zhang
 * @ Date 2021/6/8 22:02
 * @ Version 1.0.0
 */
class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    public synchronized void deposit(double amt){
        if (amt > 0) {
            balance += amt;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：存款成功。余额为：" + balance);
        }
    }
}

class Customer extends Thread {
    private Account acc;

    public Customer(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            acc.deposit(1000);
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account a = new Account(0);
        Customer c1 = new Customer(a);
        Customer c2 = new Customer(a);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
