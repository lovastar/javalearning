package com.learning.juc.synchronied;


/**
 * 写法二：可以直接写出synchronizaed(this){} 等同于 synchronized 写在方法上
 * 但是静态方法没有this对象 ,所以synchronizaed(D04_Synchronize_02.class){} 等同于 synchronized 写在方法上
 */
public class D04_Synchronize_02 {
    private int count = 10;
    private static int count01 = 10 ;

    void test() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName().toString() + "********" + count);
        }
    }


    synchronized void test_01(){
        count--;
        System.out.println(Thread.currentThread().getName().toString() + "********" + count);
    }



    static void  test_02(){
        synchronized (D04_Synchronize_02.class){    //static 不能写 synchronized (this) 因为静态方法没有this对象
            count01--;
            System.out.println(Thread.currentThread().getName().toString() + "********" + count01);
        }
    }

    synchronized  static  void test_03(){
        count01--;
        System.out.println(Thread.currentThread().getName().toString() + "********" + count01);
    }
}
