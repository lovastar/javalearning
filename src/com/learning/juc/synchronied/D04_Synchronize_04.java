package com.learning.juc.synchronied;


/**
 * 案例：银行存取款的示例
 */
public class D04_Synchronize_04 {

    private String name;
    private double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/  double getBalance() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return balance;
    }

    public static void main(String[] args) {
        D04_Synchronize_04 t = new D04_Synchronize_04();
        new Thread(() -> {
            t.set("liuxx", 10.0);
        }, "t1").start();


        new Thread(() -> {
            System.out.println(t.getBalance());
        }).start();
    }
}
