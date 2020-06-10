package com.learning.juc.cas;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * jdk提供了一个包atomic，里面的操作都是线程安全的，但是使用的是CAS方式而不是synchronized
 * atomic(原子的)：包下面的类，基本都是借助Unsafe类完成的。
 *
 * atomic包下面的类大致分为4类：原子更新普通类型、原子更新数组、原子更新引用、原子更新字段
 * 
 *原子更新基本数据类型
 *atomic 包提供了三个 提供了AtomicInteger 、AtomicLong 、AtomicBoolean
 * 其他类型如float ，double可以参考这三个类自行实现
 */
public class D06_CAS_01 {
   // private static volatile int count = 0;

    private static  AtomicInteger count = new AtomicInteger(0);
    public /*synchronized*/ void m1() {
        for (int i = 0; i < 1000; i++) {
            //count++
            count.getAndIncrement();
        }
    }

    public static void main(String[] args) {
        D06_CAS_01 t = new D06_CAS_01();
        List<Thread> threads = new ArrayList<>(20);

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m1, "t" + i));
        }

        threads.forEach(thread -> thread.start());
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(count);
    }
}
