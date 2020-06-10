package com.learning.juc.cas;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 证明CAS效率比synchronized高
 */
public class D06_CAS_02 {
    private static int count1 = 0;
    private static AtomicInteger count2 = new AtomicInteger(0);

    public  void testCas() {
        for (int i = 0; i < 100000; i++) {
            count2.incrementAndGet();
        }
    }

    public  void testSynchronized() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            synchronized (D06_CAS_02.class) {
               count1++;
            }
        }

        long end = System.currentTimeMillis();
    }

    public static void main(String[] args) throws InterruptedException {
        D06_CAS_02 t =new D06_CAS_02();
        long start2 = System.currentTimeMillis();
        List<Thread> threadSync = new ArrayList();
        for (int i = 0; i <1000 ; i++) {
            threadSync.add(new Thread(t::testSynchronized));
        }
        for (Thread thread : threadSync) thread.start();
        for (Thread thread : threadSync) thread.join();
        long end2 = System.currentTimeMillis();
        System.out.println("sync spend :"+(end2-start2));

        System.out.println("*************************");

        long start1 = System.currentTimeMillis();
        List<Thread> threadCas = new ArrayList();
        for (int i = 0; i <1000 ; i++) {
            threadCas.add(new Thread(t::testCas));
        }
        for (Thread thread : threadCas) thread.start();
        for (Thread thread : threadCas) thread.join();
        long end1 = System.currentTimeMillis();
        System.out.println("cas spend :"+(end1-start1));

    }
}
