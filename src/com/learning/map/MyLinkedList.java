package com.learning.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MyLinkedList {
    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            // linkedList.add(i);//插入时间为11151
            linkedList.add(i);//插入时间为11387
        }
        long start= System.currentTimeMillis();
        linkedList.add(1,100);
        long end = System.currentTimeMillis();
        System.out.println("插入时间为"+(end-start));

    }
}
