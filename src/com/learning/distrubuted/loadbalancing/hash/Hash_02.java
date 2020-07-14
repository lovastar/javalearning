package com.learning.distrubuted.loadbalancing.hash;

import com.learning.distrubuted.loadbalancing.ServerIps;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * hash算法：解决Hash_01中的问题
 * 思路：构造很多虚拟hashcode节点，这些虚拟hashcode对应真实的服务器ip，让这些ip分散的放在hash环上，
 * 这样某台服务器坏了，可以分散让其他服务器处理，而不是把流量全部引入下一个服务器
 *
 * 改进：这里假设每个ip权重相同，所以算法没有考虑权重
 */
public class Hash_02 {

    private static TreeMap<Integer, String> serverIpHashCodeMap = new TreeMap<>();

    private static final Integer HASH_CODE_NUMBER = 100;

    static {
        //一共可以产生HASH_CODE_NUMBER*serverIps.size()个hashcode节点
        List<String> serverIps = ServerIps.IPS;
        for (String serverIp : serverIps) {
            for (int i = 0; i <HASH_CODE_NUMBER ; i++) {
                //构造虚拟ip
                String virtual = serverIp+"vm_"+i;
                //map中存放虚拟ip的hashcode 和真实ip
                serverIpHashCodeMap.put(virtual.hashCode(), serverIp);

            }

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
