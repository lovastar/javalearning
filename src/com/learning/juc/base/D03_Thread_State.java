package com.learning.juc.base;

/**
 * new: Thread t = new Thread() 此时是new状态
 * runnable:t.start() 调用start方法进入runnable状态,其中runnable又分为ready和running
 * TimeWaiting:t.sleep(time),t.wait(time),t.join(time) 只要是带时间的等待，都是timewaiting，并且时间到了又会进入就绪队列
 * waiting:t.wait(),t.join(),LockSupport.park(),需要o.notify().notifyAll(),LockSupport.unPARK() 才能进入就绪状态
 * Bolck:同步代码 ，等待获取锁，只有获取锁才会进入就绪状态
 * TERMINATED:线程结束
 */
public class D03_Thread_State {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                //假设程序运行10s
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread run finished :");

        });
        System.out.println("thread just new state :"+t.getState());
        t.start();
        System.out.println("thread run start method state :"+t.getState());
        Thread.sleep(2000);
        System.out.println("thread sleep state :"+t.getState());
        Thread.sleep(2000);
        System.out.println("thread finished state :"+t.getState());

    }
}
