package com.learning.juc.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch:在一个线程中允许其他线程执行完后再继续执行。
 *
 * 类型：辅助工具类：在初始化CountDownLatch的时候会给一个初始值
 * 然后每调用一个countDown() ,数量-1 直到为0 才会触发await()后面的操作
 * await（）可以阻塞当前线程 .如果count值不为0，则，当前线程一直阻塞。
 *
 *
 * join()也可以使得其他线程执行完后执行当前线程。
 * 但是CountDownLatch比较灵活，因为它可以在一个线程里面连续 countDownLatch.countDown();从而达到count=0的效果
 */
public class D07_CountDownLatch_01 {

    public static void m1() {
        for (int i = 0; i < 3; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "***" + i);
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {

            threads.add(new Thread(() -> {
                m1();
                //一个线程执行完，进行减1
                countDownLatch.countDown();
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            countDownLatch.await();//等待着所有线程执行完
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("all threads finished .... ");
    }
}
