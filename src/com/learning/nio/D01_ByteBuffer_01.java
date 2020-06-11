package com.learning.nio;

import java.nio.ByteBuffer;

/**
 * 缓冲区的四个核心概念
 * position：
 * limit：
 * capacity：
 * mark：
 *
 *
 * 两大方法：
 * put():写数据
 * get():读数据
 */
public class D01_ByteBuffer_01 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);//分配一个1024的缓冲数组
        String str = "aa bb cc";

        System.out.println("初始化的buffer-----------position：" + buffer.position());
        System.out.println("初始化的buffer-----------limit：" + buffer.limit());
        System.out.println("初始化的buffer-----------capacity：" + buffer.capacity());


        buffer.put(str.getBytes());//向缓冲区存数据
        System.out.println("调用put后的buffer-----------position：" + buffer.position());
        System.out.println("调用put后的buffer-----------limit：" + buffer.limit());
        System.out.println("调用put后的buffer-----------capacity：" + buffer.capacity());


//        //buffer有写模式和读模式，当缓冲取在读取的时候没有设置读模式，默认会从当前position读，读完position会+1
//        System.out.println((char) buffer.get());
//        System.out.println("没有设置读模式的buffer-----------position：" + buffer.position());


        buffer.flip();//设置当前缓冲区为读模式
        System.out.println("调用flip后的buffer："+(char) buffer.get());
        System.out.println("调用flip后的buffer-----------position："+buffer.position());
    }
}
