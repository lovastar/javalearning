package com.learning.distrubuted.loadbalancing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerIps {

    //普通机器列表
    public static final List<String> IPS = new ArrayList<>();

    static {
        IPS.add("IP_A");
        IPS.add("IP_B");
        IPS.add("IP_C");
        IPS.add("IP_D");
        IPS.add("IP_E");
        IPS.add("IP_F");
        IPS.add("IP_G");
        IPS.add("IP_H");
    }


    //带权重的机器列表
    public static final Map<String, Integer> WEIGHT_IPS = new HashMap<>();

    static {
        WEIGHT_IPS.put("IP_A",4);
        WEIGHT_IPS.put("IP_B",5);
        WEIGHT_IPS.put("IP_C",1);
        WEIGHT_IPS.put("IP_D",5);
        WEIGHT_IPS.put("IP_E",6);
    }
}
