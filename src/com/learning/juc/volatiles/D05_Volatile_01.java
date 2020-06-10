package com.learning.juc.volatiles;


import java.util.concurrent.TimeUnit;

/**
 * volatile：保证线程可见性
 *          禁止指令重排序
 *          但是不能保证原子性，不能替代synchronized
 */
public class D05_Volatile_01 {

    private volatile boolean  flag = true;

    public void m1() {
        System.out.println("m1 start....");

        while (flag) {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("m1 end....");
    }

    public static void main(String[] args) {
        D05_Volatile_01 t = new D05_Volatile_01();
        new Thread(t::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;

    }
}
