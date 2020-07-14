package com.learning.threadlocal;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * 软引用gc条件：
 * 当软引用指向的对象没有强引用指向的时候：内存不够会被回收，内存够的情况不会被回收
 * 当软引用指向的对象有强引用指向的时候：内存不够会抛异常，内存够的情况不会被回收
 */
public class D003_reference_soft {

    public static void main(String[] args) throws IOException {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[10 * 1024 * 1024]);//10M
        System.out.println("未gc前"+softReference.get());//获取softReference指向的对象,看对象是否存在
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("gc后"+softReference.get());//GC后对象是否存在

        byte[] bytes = new byte[10*1024*1024]; //内存中再次分配10M,同时把堆内存设置为15M

        System.out.println("内存不足时"+softReference.get());//总内存（15）小于20（10+10）的情况下看软引用指向的对象是否被回收


    }
}

