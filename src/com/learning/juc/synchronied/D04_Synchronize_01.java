package com.learning.juc.synchronied;


/**
 * synchronized：对某个对象进行加锁,保证了程序的原子性和可见性。但是并不能禁止指令重排序。（synchronized必须锁的是同一个对象才会达到锁的目的)
 * 所以双重检查单例模式的对象需要加上volatile 这里的volatile作用不是保证对象的可见性，而是禁止指令重排序使用。
 * <p>
 * hotspot实现：在java对象头上有2位空间表示对象是否被锁定，
 * <p>
 * 写法一：直接new一个对象，然后每次锁定该对象。但是这样比较费事，也占用不必要的空间
 * <p>
 * 注意：
 * 1、这个对象不能发生改变（对象的属性可以发生改变，但是不能重新obj不能重新new一个对象赋给它） ，所以写成 private final Object obj = new Object()
 * 2、这个对象不能是String
 * 如果你的代码用到某个类库，里面有个方法锁的是”hello“，这个字符串。但是你不知道，你在你的业务代码里面也是锁的是“hello”对象，那么就有可能造成死锁
 * <p>
 * 3、这个对象不能是或者是Integer ，Long这类包装类
 * 比如Integer 当值大于127之后，就每次都new 一个实例，所以有可能锁得不是同一个对象
 */
public class D04_Synchronize_01 {
    private static int count = 10;
    private static Object obj = new Object();


    static void test() {
        synchronized (obj) {//任何想要执行下面代码的线程，必须拿到obj的锁
            count--;
            System.out.println(Thread.currentThread().getName().toString() + "********" + count);

       }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test();
            }
        }, "thread1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test();
            }
        }, "thread2");
        t2.start();
        t1.start();
    }


}
