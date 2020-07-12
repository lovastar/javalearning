package com.learning.distrubuted.loadbalancing.random;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.List;
import java.util.Random;

/**
 * 随机算法:最简单算法
 *     优点：简单
 *     缺点：实际生产中，这些机器性能肯定存在差异，按照这个算法，每台机器获取的机会都是均等的，但是实际中可能需要
 *     性能好的机器获取的机会大，但是性能差的机器获取机会少。
 */
public class Random_01 {

    public static String getIps() {
        //获取所有的ip
        List<String> ips = ServerIps.IPS;

        //使用java Random类 ,从0-机器数量 里面获取一个随机数
        Random random = new Random();
        int randomNumber = random.nextInt(ips.size());

        return ips.get(randomNumber);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "次获取的ip：" + getIps());
        }
    }
}
