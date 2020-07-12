package com.learning.distrubuted.loadbalancing.roundrobin;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 普通轮询算法
 * 缺点：实际生产中，这些机器性能肯定存在差异，按照这个算法，每台机器获取的机会都是均等的，但是实际中可能需要
 *      性能好的机器获取的机会大，但是性能差的机器获取机会少。
 */
public class RoundRobin_01 {
    private static AtomicInteger count = new AtomicInteger(0);

    public static String getIps() {
        //使用AtomicInteger 是因为存在并发问题
        if (count.get() > (ServerIps.IPS.size() - 1)) {
            count.set(0);
        }
        return ServerIps.IPS.get(count.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println("第" + i + "次获取的ip：" + getIps());
        }
    }
}
