package com.learning.juc.cas;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 证明CAS效率比synchronized高
 */
public class D06_CAS_03 {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        System.out.println("getAndIncrement:"+count.getAndIncrement()); //get在前，返回旧值


        int count1 = 0 ;
        System.out.println("count++:"+count1++);

        AtomicInteger count2 = new AtomicInteger(0);
        System.out.println("incrementAndGet:"+count2.incrementAndGet());//get在后，返回新值

        int count3 = 0 ;
        System.out.println("++count:"+(++count3));
    }
}
