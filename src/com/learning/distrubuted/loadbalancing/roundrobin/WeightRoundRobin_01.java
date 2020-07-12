package com.learning.distrubuted.loadbalancing.roundrobin;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加权轮询算法——1
 * 缺点：如果权重很大，那么占用内存大。内存的占用大小和权重成正比
 */
public class WeightRoundRobin_01 {
    private static AtomicInteger count = new AtomicInteger(0);
    public static List<String> ipList = new ArrayList<>();

    static {
        Map<String, Integer> weight = ServerIps.WEIGHT_IPS;

        for (String ip : weight.keySet()) {
            for (int i = 0; i < weight.get(ip); i++) {
                ipList.add(ip);
            }
        }
    }

    public static String getIps() {

        if (count.get() >= ipList.size()) {
            count.set(0);
        }
        return ipList.get(count.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println("第" + i + "次获取的ip：" + getIps());
        }
    }
}
