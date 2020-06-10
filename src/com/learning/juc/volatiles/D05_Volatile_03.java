package com.learning.juc.volatiles;


import java.util.ArrayList;
import java.util.List;

/**
 * 证明volatile不能保证原子性
 */
public class D05_Volatile_03 {
    private static volatile int count = 0;

    public /*synchronized*/ void m1() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        D05_Volatile_03 t = new D05_Volatile_03();
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
