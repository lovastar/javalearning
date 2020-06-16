package com.learning.juc.synchronied;


/**
 */
public class D04_Synchronize_011 {

    public   void m1(Integer lock){
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " m1 start running.....");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m1 end running.....");
        }

    }


    public static void main(String[] args) {
        D04_Synchronize_011 t = new D04_Synchronize_011();

        new Thread(()->{
            t.m1(133); //11
        },"t1").start();

        //t1 t2 线程使用不同的对象锁
        new Thread(()->{
            t.m1(133); //
        },"t2").start();

    }
}
