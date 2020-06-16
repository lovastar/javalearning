package com.learning.juc.synchronied;


import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;


/**
 *
 * 证明String 类型的锁可能造成线程不必要的等待
 *
 */
public class D04_Synchronize_08 {


    //模拟正常业务代码
    public static void m1(){
        synchronized ("hello"){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1 invoked");
        }
    }


    //模拟某个框架的方法
    public static void m2(){
        synchronized ("hello"){
           // synchronized ("hello1"){ //如果使用不同的锁，则不会阻塞
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m2 invoked");
        }
    }
    public static void main(String[] args) {

        new Thread(()->{
            m1();
        },"t1").start();

        new Thread(()->{
            m2();
        },"t2").start();
    }
}
