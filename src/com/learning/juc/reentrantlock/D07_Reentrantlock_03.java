package com.learning.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock:可以使用lockInterruptibly()进行加锁，可以使用interrupt()使得某个线程在等待过程中可以被打断。
 */
public class D07_Reentrantlock_03 {
    Lock lock = new ReentrantLock();

    public void m1() {
        try {
            lock.lock(); //相当于synchronizsuoed
            System.out.println("m1 start ....");
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            System.out.println("m1 end ....");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //不同于synchronized自动释放锁， ReentrantLock 必须手动释放锁，而且最好写在finally里面，从而保证锁一定被释放
        }

    }

    public void m2() {
        try {
            lock.lockInterruptibly(); //  加锁
            System.out.println("m2 running ....");
        } catch (InterruptedException e) {
            System.out.println(" m2 interrupted ....");
        } finally {
            if (lock.tryLock()) lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        D07_Reentrantlock_03 t = new D07_Reentrantlock_03();
        new Thread(t::m1, "t1").start();

        Thread tt = new Thread(t::m2, "t2");
        tt.start();
        TimeUnit.SECONDS.sleep(3);

        tt.interrupt();

    }
}
