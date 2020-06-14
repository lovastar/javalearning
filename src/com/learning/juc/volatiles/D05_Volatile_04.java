package com.learning.juc.volatiles;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 小demo 证明cpu的乱序执行
 * 执行顺序 ：1-2-3-4 结果：x=0 y=1
 * 1-3-4-2 结果：x=1 y=1
 * 1-3-2-4 结果：x=1 y=1
 * 3-4-1-2 结果：x=1 y=0  ......
 * 无论哪个线程先执行，如果没有发生乱序执行，那么肯定是1或3先执行，那么xy的结果肯定有一个是1，所以肯定不会出现0，0
 */
public class D05_Volatile_04 {

    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) {
        int i = 0;
        for (; ; ) {
            CountDownLatch countDownLatch = new CountDownLatch(2);
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread t1 = new Thread(() -> {
                a = 1; //1
                x = b;//2

                countDownLatch.countDown();
            });

            Thread t2 = new Thread(() -> {
                b = 1;//3
                y = a;//4

                countDownLatch.countDown();
            });
            t1.start();
            t2.start();

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次，(x=" + x + ",y=" + y + ")");
            }
        }
    }
}
