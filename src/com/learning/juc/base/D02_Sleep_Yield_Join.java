package com.learning.juc.base;

public class D02_Sleep_Yield_Join {

    /**
     * sleep：时间到了会进入就绪队列，
     */
    static void testThreadSleep(){
        new Thread(()->{

        }).start();
    }

    /**
     * 线程礼让，表示当前线程放弃cpu的调度，重新进入就绪队列，但是cpu下一次调度有可能还是这个线程
     */
    static void testThreadYield(){

    }


    /**
     * t1.join():表示让t1被cpu调度，等到t1线程结束，当前线程才会继续往下执行
     */
    static void testThreadJoin(){

      Thread t1=  new Thread(()->{
          System.out.println("t1 start");
          try {
              Thread.sleep(10000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      });

      Thread t2 = new Thread(()->{
          System.out.println("before t1 join....");
          try {
              t1.join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("after t1 join .....");
      });
      t2.start();
      t1.start();
    }
    public static void main(String[] args) {

        testThreadJoin();
    }
}
