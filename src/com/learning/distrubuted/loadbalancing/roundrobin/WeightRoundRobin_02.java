package com.learning.distrubuted.loadbalancing.roundrobin;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 加权轮询算法——2
 * 思路：权重坐标
 * 缺点：轮询算法不似随机算法，轮询的offset是依次递增的，那么假设"IP_A",1000，在很长一段时间内，获得的机器ip都是IP_A，而其他机器
 *      无法处理请求。
 */
public class WeightRoundRobin_02 {
    private static AtomicInteger count = new AtomicInteger(0);

    private static final Map<String, Integer> ipMap = ServerIps.WEIGHT_IPS;

    /**
     * 判断所有机器权重是否相同
     *
     * @return
     */
    private static boolean isSameWeight() {
        Set<Integer> distinctWeight = new HashSet<>();
        for (String ip : ipMap.keySet()) {
            distinctWeight.add(ipMap.get(ip));
        }
        return distinctWeight.size() == 1;
    }

    public static String getIps() {

        if (isSameWeight()) {
            //所有权重相同，按照普通轮询算法
            System.out.println("进入普通轮询算法");
            List<String> ips = ipMap.keySet().stream().collect(Collectors.toList());
            if (count.get() >= ips.size()) {
                count.set(0);
            }
            return ips.get(count.getAndIncrement());
        } else {
            System.out.println("权重坐标轮询算法");
            //权重不同，按照权重坐标方法计算
            int weightSum = 0;
            for (String ip : ipMap.keySet()) {
                weightSum += ipMap.get(ip);
            }

            if (count.get() >= weightSum) {
                count.set(0);
            }
            int offset = count.getAndIncrement();
            for (String ip : ipMap.keySet()) {
                int weight = ipMap.get(ip);
                if (offset < weight) {
                    return ip;
                }
                offset = offset - weight;
            }
            return "";
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println("第" + i + "次获取的ip：" + getIps());
        }
    }
}
