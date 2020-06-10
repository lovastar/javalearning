package com.learning.juc.synchronied;


/**
 * 默认情况下，如果发生异常，锁会被释放，如果想要不释放锁，必须使用catch
 */
public class D04_Synchronize_06 {
    private int count = 0;

    public synchronized void m1() {
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + "******" + count);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) { //synchronized 修饰的方法如果发生异常，锁就会进行释放。那么此时如果有另一个线程等待锁，
                // 就会出现另一个线程直接使用当前线程的一些中间数据，造成系统错误。此时要想锁不释放，就要使用catch
                //try {
                int i = 10 / 0;
                // }catch (Exception e){
                //   e.printStackTrace();
                //}
            }
        }
    }

    public static void main(String[] args) {
        D04_Synchronize_06 t = new D04_Synchronize_06();
        new Thread(t::m1, "t1").start();
        new Thread(t::m1, "t2").start();

    }
}
