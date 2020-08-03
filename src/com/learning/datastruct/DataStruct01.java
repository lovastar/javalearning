package com.learning.datastruct;


public class DataStruct01 {

    /**
     * 题目描述
     * 给定m个正数N 在[0,100]之间，以最快的速度判断N是不是在以下数据中，5，10 ，13，87，66，90
     * <p>
     * 思路：构造一个数组，大小为100，默认值为0 ，然后让这些值作为数组的下表，数组的元素设置为1，
     * 那么 arr[5]=1,arr[10]=1,arr[13]=1,arr[87]=1,arr[66]=1,arr[90]=1,
     * <p>
     * 问题，N的范围较小的时候适用，比如N在[0,10000000000000000]之间就不适用了
     */
    public static boolean sulotion_1(int num) {
        int exemple[] = {5, 10, 13, 87, 66, 90}; //样例数据
        int arr[] = new int[100];
        for (int i = 0; i < exemple.length; i++) {
            arr[exemple[i]] = 1;
        }
        if (arr[num] == 0) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 题目描述
     * 给定m(10)个正数N 在[0,10000000000000000]之间，以最快的速度判断N是不是在以下数据中，5，10 ，13，87，66，90
     * <p>
     * 思路：构造一个数组，但是此时数组的大小不能是10000000000000000，因为开辟不了这么大的空间
     * 这时候可以采用对m取余
     * arr[5%10]=arr[5]=5
     * arr[10%10]=arr[0]=10
     * arr[13%10]=arr[3]=13
     * ......
     *
     * 问题：会发生hash冲突
     */
    public static boolean sulotion_2(int num, int m) {
        int exemple[] = {5, 10, 13, 87, 66, 90}; //样例数据
        int arr[] = new int[m];
        for (int i = 0; i < exemple.length; i++) {
            arr[exemple[i] % m] = exemple[i];
        }
        if (arr[num % m] == num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("90：" + sulotion_1(90));
        System.out.println("1：" + sulotion_1(1));

        System.out.println("90：" + sulotion_2(90,10));
        System.out.println("1：" + sulotion_2(1,10));

    }
}
