package com.learning.juc.synchronied;


/**
 * 1、假设一个线程在访问synchronized方法的时候，另一个线程是不是可以同时另一个访问非synchronized方法----（可以）
 * 2、假设一个线程在访问synchronized方法的时候，另一个线程是不是可以同时访问另一个synchronized方法---（不可以）
 */
public class D04_Synchronize_03 {

    public synchronized  void m1(){
        System.out.println(Thread.currentThread().getName()+" m1 start running.....");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m1 end running.....");

    }

    public /*synchronized*/  void m2(){
        try {
            Thread.sleep(1000);//确保m1开始执行了，m2才开始
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2 running....");
    }

    public static void main(String[] args) {
        D04_Synchronize_03 t = new D04_Synchronize_03();
        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();

    }
}
