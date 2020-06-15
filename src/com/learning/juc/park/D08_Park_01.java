package com.learning.juc.park;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class D08_Park_01 {

    public static  void m1(){
        System.out.println("m1 start.....");
        LockSupport.park();//这里的park实际上调用的是Unsafe的park。
        System.out.println("m1 end ....");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            m1();
        });
        t1.start();

        TimeUnit.SECONDS.sleep(2);

        LockSupport.unpark(t1); //unpark()方法需要传入需要唤醒的线程:
        System.out.println("main  end ....");
    }
}
