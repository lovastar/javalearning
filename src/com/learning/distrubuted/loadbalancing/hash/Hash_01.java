package com.learning.distrubuted.loadbalancing.hash;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * hash算法：
 * 思路：客户端ip-------->hashCode-------------->服务端ip，所以需要构造ip和hashcode的映射
 * 由于客户端ip无法提前知道，所以无法构造客户端ip和其hyiashcode映射，但是服务器端ip是可以提前知道的
 * 所以构造服务器端ip和其hashcode的映射
 *
 * 缺点，机器有几台，哈希环上就有几个几点，假设一共5台机器，连续有2台宕机了，那么后面一台需要承受3台的压力，这样每台机器的压力就不均匀了
 * 怎么使得每台机器压力比较均匀呢
 */
public class Hash_01 {

    //使用treeMap来放映射关系是因为treemap底层实现是红黑树，已经是排好序的，对于这里取大于某个hashcode很方便
    private static TreeMap<Integer, String> serverIpHashCodeMap = new TreeMap<>();

    static {
        //构造hashCode和ip映射关系
        List<String> serverIps = ServerIps.IPS;
        for (String serverIp : serverIps) {
            serverIpHashCodeMap.put(serverIp.hashCode(), serverIp);

        }
    }

    public static String getIps(String clientIp) {
        System.out.println("clientIp:"+clientIp);
        //获取客户端ip的hashCode，这里获取hashCode 用的是自带的，也可以自己实现
        int clientIpHashCode = clientIp.hashCode();

        //获取大于clientIpHashCode的子树
        SortedMap<Integer, String> sortedMap = serverIpHashCodeMap.tailMap(clientIpHashCode);

        //如果是最底层叶子节点，那么它的子树为空,那么这时候应该返回根节点，这样就能形成一个环（哈希环）
        // 因为在实际开发中，不可能让大于最大的那部分客户端获取不到服务，这部分客户端应该调用根节点hash所对应的ip信息
        if (sortedMap == null || sortedMap.size()==0) {
            return serverIpHashCodeMap.get(serverIpHashCodeMap.firstKey());
        }

        //返回子树的第一个节点
        return sortedMap.get(sortedMap.firstKey());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println("第" + i + "次获取的ip：" + getIps("client_ip_i"+i));
        }
    }

}
