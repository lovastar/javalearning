package com.learning.map;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {

    public static void main(String[] args) {

        int a = 1;
        long start = System.currentTimeMillis();
        for (int i = 1; i < 1000000000; i++) {
            a = a & i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
