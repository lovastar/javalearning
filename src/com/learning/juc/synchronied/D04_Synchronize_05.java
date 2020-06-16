package com.learning.juc.synchronied;


/**
 *synchronized可重入锁
 * 可重入的概念:一个线程已经拿到当前对象的锁以后可以再次拿这个对象的锁吗？
 * 简单来说就是一个synchronized修饰的方法里面可以调用另一个synchronized修饰的方法吗---可以
 * 场景：父类synchronized m1 子类synchronized m1(super m1())
 * 每次加锁都+1 ，执行完一个就-1
 *
 */
public class D04_Synchronize_05 {
    public synchronized  void m1(){
        System.out.println(Thread.currentThread().getName()+" m1 start running.....");
        try {
            Thread.sleep(6000);
            //假如不可重入，那么执行m2需要拿当前对象的锁，但是当前对象的锁已经被m1执行的时候拿掉到了，
            // 而m1还没执行完，所以锁没有被释放，这样就造成死循环。所以synchronized必须是可重入的锁
            m2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m1 end running.....");

    }

    public synchronized void m2(){
        try {
            Thread.sleep(1000);//确保m1开始执行了，m2才开始
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2 running....");
    }

    public static void main(String[] args) {
        D04_Synchronize_05 t = new D04_Synchronize_05();
        new Thread(t::m1,"t1").start();
    }
}
