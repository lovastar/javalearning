package com.learning.juc.volatiles;


/**
 * volatile：保证线程可见性
 * 禁止指令重排序
 */
public class D05_Volatile_02 {
    private static  /*volatile*/ D05_Volatile_02 d05_Volatile_02;

    private D05_Volatile_02() {
    }


    public static D05_Volatile_02 getInstance() {
        if (d05_Volatile_02 == null) {
            synchronized (D05_Volatile_02.class) {
                if (d05_Volatile_02 == null) {
                    d05_Volatile_02 = new D05_Volatile_02();
                }
            }
        }
        return d05_Volatile_02;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            getInstance();
        }, "t1").start();

        new Thread(() -> {
            getInstance();
        }, "t2").start();

        new Thread(() -> {
            getInstance();
        }, "t3").start();
    }

}
