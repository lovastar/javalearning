package com.learning.juc.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class D07_CountDownLatch_02 {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);


    public static void main(String[] args) throws InterruptedException {
        System.out.println("before value change to 0 ");
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 5; i++) {
                countDownLatch.countDown();
                System.out.println("before value change to :" + countDownLatch.getCount());
            }
        }).start();

        countDownLatch.await();
        System.out.println("after value change to 0 ");
    }
}
