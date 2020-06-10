package com.learning.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程使用同一把锁，那么线程t2需要等到t1执行完后才会执行。类似于synchronized（非公平锁）
 */
public class D07_Reentrantlock_01 {
    Lock lock = new ReentrantLock();   //非公平锁     reentrantlock :默认是非公平锁
   // Lock lock = new ReentrantLock(true);  //公平锁


    public void m1() {
       // Lock lock = new ReentrantLock();
        try {
            lock.lock(); //相当于synchronizsuoed
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + " m1 running ..." + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //不同于synchronized自动释放锁， ReentrantLock 必须手动释放锁，而且最好写在finally里面，从而保证锁一定被释放
        }

    }

    public void m2() {
        //Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " m1 running ...");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        D07_Reentrantlock_01 t = new D07_Reentrantlock_01();
        new Thread(t::m1, "t1").start();
        TimeUnit.SECONDS.sleep(3);//确保t1 已经启动
        new Thread(t::m2, "t2").start();

    }
}
