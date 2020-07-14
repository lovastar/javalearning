package com.learning.distrubuted.loadbalancing.random;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 随机算法:加权随机算法——1
 * 思路：全新构造ip_list，权重是几，ip就存放几次
 * 缺点：如果权重很大，那么占用内存大。内存的占用大小和权重成正比
 */
public class WeightRandom_01 {

    public static String getIps() {
        //获取所有的ip
        Map<String, Integer> weightIps = ServerIps.WEIGHT_IPS;

        //全新构造ip_list，权重是几，ip就存放几次
        List<String> ips = new ArrayList<>();
        for (String ip : weightIps.keySet()) {
            //存放权重次ip
            for (int i = 0; i < weightIps.get(ip); i++) {
                ips.add(ip);
            }
        }

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
