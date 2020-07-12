package com.learning.distrubuted.loadbalancing.random;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.Map;
import java.util.Random;

/**
 * 随机算法:加权随机算法——2
 *针对WeightRandom_02中的优化点进行改进
 */
public class WeightRandom_03 {

    public static String getIps() {


        return null;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "次获取的ip：" + getIps());
        }
    }
}
