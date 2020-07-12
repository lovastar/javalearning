package com.learning.juc.synchronied;


/**
 * 证明对象锁使用基本数据类型的包装类可能造成问题
 */
public class D04_Synchronize_011 {

    public   void m1(Integer lock){
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " m1 start running.....");
            try {
                Thread.sleep(6000);//采用休眠方式模拟正常业务处理
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m1 end running.....");
        }

    }


    public static void main(String[] args) {
        D04_Synchronize_011 t = new D04_Synchronize_011();

        new Thread(()->{
            t.m1(1); //11
        },"t1").start();

        //t1 t2 线程使用不同的对象锁
        new Thread(()->{
            t.m1(1); //
        },"t2").start();

    }
}
