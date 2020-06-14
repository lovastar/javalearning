package com.learning.juc.synchronied;


import org.openjdk.jol.info.ClassLayout;


/**
 *
 * 观察对象内存的工具
 *  <dependency>
 *       <groupId>org.openjdk.jol</groupId>
 *       <artifactId>jol-core</artifactId>
 *        <version>0.9</version>
 *  </dependency>
 */
public class D04_Synchronize_07 {
    public static void main(String[] args) {

        Object obj = new Object();

        System.out.println("对象加锁前-------------------------------");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println("对象加锁后-------------------------------");
        //对obj加锁，观察对象内存变化
        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }
}
