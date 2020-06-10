package com.learning.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock:可以使用tryLock进行尝试获取锁，而synchronized一旦已经被锁定，则其他线程只能进入等待队列
 */
public class D07_Reentrantlock_02 {
    Lock lock = new ReentrantLock();

    public void m1() {
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
        boolean canGetLock = false;
        try {
            canGetLock = lock.tryLock(3, TimeUnit.SECONDS);//3秒之内是否可以拿到锁。可以使用lock.tryLock()判断当前锁是否被占用
            System.out.println(Thread.currentThread().getName() + "can get lock:" + canGetLock);

            if (canGetLock) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " m1 running ...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(canGetLock)  lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        D07_Reentrantlock_02 t = new D07_Reentrantlock_02();
        new Thread(t::m1, "t1").start();
        TimeUnit.SECONDS.sleep(3);//确保t1 已经启动
        new Thread(t::m2, "t2").start();

    }
}
