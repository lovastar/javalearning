package com.learning.juc.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 模拟100个用户，每个用户发起10个请求，统计一共有多少个请求
 */
public class DemoImplove {
    private volatile static int count = 0;


    public synchronized  static boolean compareAndSwap(int exceptValue ,int newValue){
        if(getCount()==exceptValue){//如果当前值和期望值一致，那么当前值设置为新值，并且返回true
            count = newValue;
            return true;
        }
        return false ;
    }

    public static int getCount(){
        return count;
    }
    public static void service() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(10);

        //为什么不直接exceptValue = getCount()，因为如果这时候赋值的话，当第一次失败，下一次进入cas的exceptValue不是最新的值，而是上一次的值
        int exceptValue   ;
        while (!compareAndSwap(exceptValue=getCount(),exceptValue +1)){}
    }

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 100;//并发线程
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        long start = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        service();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            });
            thread.start();
        }

        countDownLatch.await();//使用countDownLatch 保证所有线程执行完成后 才继续往下执行
        long end = System.currentTimeMillis();

        System.out.println("总耗时：" + (end - start) + ", count的值为：" + count);
    }
}
