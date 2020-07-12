package com.learning.map;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("aa",1);
        map.put("aa",2);
        System.out.println(map.get("aa"));

    }
}
