package com.learning;

import java.util.concurrent.TimeUnit;


/**
 * 测试stringBuilder线程不安全特性
 */


public class StringBuilderTest {

    static {
        System.out.println("StringBuilderTest 初始化");
    }


    public static void main(String[] args) throws InterruptedException {


        //构造一个共享变量
        StringBuilder sb = new StringBuilder();

        //开启线程，修改共享变量sb
        for (int i = 0; i <10 ; i++) {

            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    sb.append(j);
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println("预期值是：10*100，实际值："+sb.length());
    }
}
