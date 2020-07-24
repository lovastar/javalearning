package com.learning.threadlocal;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * 软引用创建
 */
public class D002_reference_soft {

    public static void main(String[] args) throws IOException {
        T t = new T();//步骤1
        SoftReference<T> softReference = new SoftReference<>(t);//步骤2：创建一个软引用，指向t指向的堆中的对象
        System.out.println(softReference.get());//获取softReference指向的对象
        System.out.println(softReference.get()==t); //证明软引用指向的对象和t指向的对象是同一个对象
    }
}

class T {
    @Override
    protected void finalize() throws Throwable {
        //finalize 对象被回收的时候调用
        System.out.println("m is gc......");
    }
}

