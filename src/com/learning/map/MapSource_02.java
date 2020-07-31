package com.learning.map;

/**
 * 比较&运算和%运算效率
 *100000      & 1 , % 1
 *1000000     & 3 , % 8
 *10000000    & 10 , % 90
 *100000000   & 41 , % 839
 *1000000000  & 369 , % 8575
 */
public class MapSource_02 {

    public static void main(String[] args) {

        //&
        int a = 1;
        long start = System.currentTimeMillis();
        for (int i = 1; i < 1000000000; i++) {
            a = a & i;
        }
        long end = System.currentTimeMillis();
        System.out.println("& : "+(end - start));

        //%
        int b = 1;
        long start_1 = System.currentTimeMillis();
        for (int i = 1; i < 1000000000; i++) {
            b = b % i;
        }
        long end_1 = System.currentTimeMillis();
        System.out.println("% : "+(end_1 - start_1));
    }
}
