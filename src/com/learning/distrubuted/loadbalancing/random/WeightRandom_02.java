package com.learning.distrubuted.loadbalancing.random;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 随机算法:加权随机算法——2
 *
 * 假设存在以下机器列表
 *  "IP_A",4
 *  "IP_B",5
 *  "IP_C",1
 * 思路：构造权重坐标0----4-----9-10
 *      从偏移量0-9中获取随机数作为偏移量，如果偏移量是[0,4),返回IP_A ; [4,9),返回IP_B ;[9,10),返回IP_C
 *      也就是说：假设偏移量7  ，7<4 不满足，那么进行7-4 =3< 5 满足，则返回机器IP_B
 *
 * 改进点：当所有机器权重都是一样的（也就是从相当于没有权重），那么可以用普通随机算法。
 * 目前生产随机算法主要用的就是当前方式。
 */
public class WeightRandom_02 {

    public static String getIps() {
        //获取所有的ip
        Map<String, Integer> weightIps = ServerIps.WEIGHT_IPS;

        //计算总权重
        int weightSum = 0;
        for (String ip : weightIps.keySet()) {
            weightSum += weightIps.get(ip);
        }

        //获取随机offset
        int offset = new Random().nextInt(weightSum);

        for (String ip : weightIps.keySet()) {
            int weight = weightIps.get(ip);
            //如果offset<weight,offset满足当前机器的权重范围。
            if(offset<weight){
                return ip;
            }
            //如果offset>=weight,offset=offset-当前ip权重，然后进行下一个机器判断
            offset = offset-weight;
        }


        return "";
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "次获取的ip：" + getIps());
        }
    }
}
