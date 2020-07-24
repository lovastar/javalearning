package com.learning.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MyHashMap {

    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(0);
        Map<Integer,Integer> testMap = new HashMap<>();

        for (int i = 0; i <1000 ; i++) {
            new Thread(()->{
                for (int j = 0; j <100000 ; j++) {
                    testMap.put(count.get(), count.get());
                    count.incrementAndGet();
                }
            }).start();
        }
        System.out.println(count.get());

        int a = 1;
        long start = System.currentTimeMillis();
        for (int i = 1; i < 1000000000; i++) {
            a = a & i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
