package com.learning.distrubuted.loadbalancing.roundrobin;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 加权轮询算法——3平滑加权轮询算法
 * 思路：
 */
public class WeightRoundRobin_03 {

    public static String getIps() {

       return "";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println("第" + i + "次获取的ip：" + getIps());
        }
    }
}
