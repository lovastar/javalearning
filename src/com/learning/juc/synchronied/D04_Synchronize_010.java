package com.learning.juc.synchronied;


/**
 * 不同锁对象：
 *
 * 假设一个线程在访问synchronized方法的时候，另一个线程是不是可以同时访问另一个synchronized方法---（可以）
 */
public class D04_Synchronize_010 {

    public   void m1(Object obj){
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " m1 start running.....");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m1 end running.....");
        }

    }

    public  void m2(Object obj){
        synchronized (obj) {
            try {
                Thread.sleep(1000);//确保m1开始执行了，m2才开始
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m2 running....");
        }
    }

    public static void main(String[] args) {
        D04_Synchronize_010 t = new D04_Synchronize_010();

        new Thread(()->{
            t.m1(new Object());
        },"t1").start();

        //t1 t2 线程使用不同的对象锁
        new Thread(()->{
            t.m1(new Object());
        },"t2").start();

    }
}
