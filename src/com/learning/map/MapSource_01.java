package com.learning.map;


/**
 * jdk中 给定一个值，获取比它大或者相等的2的幂次方的2中实现方式
 */
public class MapSource_01 {


    public static int m_01(int cap) {
        int n = 1;
        int i = 0;

        while (n < cap) {
            i++;
            n = n << 1;
        }
        System.out.println("移动" + i + "次");
        return n;
    }


    public static int m_02(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return n==0?0:n+1;
    }

    public static void main(String[] args) {
        System.out.println(m_01(4));

    }
}
