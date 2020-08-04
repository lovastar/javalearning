package com.learning.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 *
 * 比较在高并发的场景下，比较LongAdder和AtomicLong的自增效率
 *
 * 在高并发场景下，如果是自增平凡的业务场景，那么LongAdder的效率是AtomicLong的10多倍
 *
 * ===============1 thread ,10000000 times===============
 * AtomicLong:110
 * LongAdder:108
 * ===============10 thread ,10000000 times===============
 * AtomicLong:2020
 * LongAdder:215
 * ===============20 thread ,10000000 times===============
 * AtomicLong:4358
 * LongAdder:540
 * ===============100 thread ,10000000 times===============
 *
 */
public class LongAdderTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("===============1 thread ,10000000 times===============");
        testAtomicLong(1,10000000);
        testLongAdder(1,10000000);

        System.out.println("===============10 thread ,10000000 times===============");
        testAtomicLong(10,10000000);
        testLongAdder(10,10000000);

        System.out.println("===============20 thread ,10000000 times===============");
        testAtomicLong(20,10000000);
        testLongAdder(20,10000000);

        System.out.println("===============100 thread ,10000000 times===============");
        testAtomicLong(100,10000000);
        testLongAdder(100,10000000);
    }

    public static  void testAtomicLong(int threadNumber, int times) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
        AtomicLong atomicLong = new AtomicLong(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i <threadNumber ; i++) {
            new Thread(()->{
                for (int j = 0; j <times ; j++) {
                    atomicLong.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("AtomicLong:"+(end-start));
    }

    public static void  testLongAdder(int threadNumber ,int times) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
        LongAdder longAdder = new LongAdder();
        long start = System.currentTimeMillis();
        for (int i = 0; i <threadNumber ; i++) {
            new Thread(()->{
                for (int j = 0; j <times ; j++) {
                    longAdder.increment();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("LongAdder:"+(end-start));
    }
}
