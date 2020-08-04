package com.learning.juc.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 模拟100个用户，每个用户发起10个请求，统计一共有多少个请求
 */
public class Demo {
    private static int  count=0 ;

    /**
     *                   1线程   2个线程     100线程
     * 不加synchronized：  67     75          87
     *  加synchronized：   68     86         1862
     *  可以看出来多线程如果不加synchronized，总耗时基本和单线程差不多
     *  但是如果加了synchronized，如果线程数量越多，耗时越多 当线程为100的时候不加synchronized的时间约是加了后的25倍数
     */
    public   synchronized static void service() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(100);
        count ++ ; //不是原子操作：1、获取count的值a 2、将a值+1得到b 3、将b赋值给a
    }
    public static void main(String[] args) throws InterruptedException {

        int threadCount = 100;//并发线程
        CountDownLatch countDownLatch = new CountDownLatch(threadCount); //
        long start = System.currentTimeMillis();

        for (int i = 0; i <threadCount ; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 10; j++) {
                   try{
                       service();
                   }catch (Exception e){
                       e.printStackTrace();
                   }
                }
                countDownLatch.countDown();
            });
            thread.start();
        }

        countDownLatch.await();//使用countDownLatch 保证所有线程执行完成后 才继续往下执行
        long end = System.currentTimeMillis();

        System.out.println("总耗时："+(end - start)+", count的值为："+count);
    }
}
