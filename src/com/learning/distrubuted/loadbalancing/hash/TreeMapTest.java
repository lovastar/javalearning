package com.learning.distrubuted.loadbalancing.hash;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(5, 5);
        treeMap.put(2, 2);
        treeMap.put(1, 1);
        treeMap.put(3, 3);
        treeMap.put(4, 4);



        System.out.println("firstKey:" + treeMap.firstKey());
        System.out.println("floorKey:" +treeMap.floorKey(3));
        System.out.println("lastKey:" +treeMap.lastKey());
        SortedMap<Integer, Integer> sortedMap = treeMap.tailMap(3);
        System.out.println("sortedMap.firstKey:"+sortedMap.firstKey());

    }
}
