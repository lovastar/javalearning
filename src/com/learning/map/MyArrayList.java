package com.learning.map;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {
    public static void main(String[] args) {

        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
           arrList.add(i);//    插入时间为5738


        }
        long start= System.currentTimeMillis();
        arrList.add(1,100);//插入时间为5617
        long end = System.currentTimeMillis();
        System.out.println("插入时间为"+(end-start));

    }
}
