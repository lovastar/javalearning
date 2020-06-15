package com.learning.juc.reentrantlock;

import java.util.Queue;

/**
 * 模拟reentrantLock: park+自旋
 */
public class D07_Reentrantlock_test_02 {

    private volatile int status = 0;//标记是否可以加锁
    private Queue<Thread> parkQueue; //存放所有CAS失败的线程，调用park后进入的等待队列

    public void lock() {

        while (!compareAndSet(0, 1)) {
            //为什么使用park() 而不用sleep()---------->sleep需要指定休眠时间，但是线程执行的时间无法确定，所以使用sleep可能造成时间到了，但是线程没有执行完， 或者线程执行完了，但是休眠时间还没到。
            park();//进入等待队列
        }
    }

    public void unlock() {
        status = 0;//修改状态为未加锁的状态
        lockNotify();//唤醒下一个线程执行
    }

    public void park() {

        //当前线程加入park等待队列
        parkQueue.add(Thread.currentThread());

        //释放cpu资源
        releaseCpu();
    }


    public void lockNotify() {
        if (!parkQueue.isEmpty()) {
            Thread nextThread = parkQueue.peek();//取出下一个线程
            unPark(nextThread);//唤醒
        }
    }


    public void releaseCpu() {

    }

    public void unPark(Thread nextThread) {

    }

    //CAS自旋
    boolean compareAndSet(int exceptValue, int newValue) {
        if (status == exceptValue) {
            status = newValue;
            return true;
        }
        return false;
    }
}
