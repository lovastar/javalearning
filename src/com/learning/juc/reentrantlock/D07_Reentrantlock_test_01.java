package com.learning.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟reentrantLock：
 *
 *  假设：线程A进行cas成功，把status设置为1 当A在未unlock的时候
 *       线程B和线程C也调用lock().那么如果A执行很久很久，线程B和C就要长时间进行循环，消耗cpu资源
 */
public class D07_Reentrantlock_test_01 {

    private volatile int status = 0;//标记是否可以加锁

    public void lock() {

        while (!compareAndSet(0, 1)) {
          //如果CAS失败，则一直循环，消耗cpu资源
        }

    }

    public void unlock() {
       status = 0 ;
    }


    //CAS自旋
    boolean compareAndSet(int exceptValue, int newValue) {

        return false;
    }
}
