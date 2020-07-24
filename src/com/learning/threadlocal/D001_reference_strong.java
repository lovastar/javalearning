package com.learning.threadlocal;

import java.io.IOException;

/**
 * 强引用：  M m = new M(); 也就是我们平时创建的对象基本都是强引用
 * 垃圾回收的条件：只有
 */
public class D001_reference_strong {

    public static void main(String[] args) throws IOException {
         M m = new M();
         m = null ;
         System.gc();

        // System.in.read() 阻塞当前线程，等待控制台输入，遇到回车结束
         System.in.read();//这里用来阻塞main线程，保证gc完成，也就是如果我控制台一直不输入回车，main线程不会结束。也就能保证gc完成
    }
}

class M {
    @Override
    protected void finalize() throws Throwable {
        //finalize 对象被回收的时候调用
        System.out.println("m is gc......");
    }
}