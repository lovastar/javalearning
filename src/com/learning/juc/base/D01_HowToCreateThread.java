package com.learning.juc.base;

/**duo
 * 创建线程
 * 线程启动用start()而不是run方法，使用run()不会产生多线程的效果，而是单线程
 */
public class D01_HowToCreateThread {

   static class MyThread01 extends Thread{
        @Override
        public void run() {
            System.out.println(" thread extends Thread running ... ");
        }
    }


    static class MyThread02  implements Runnable{

        @Override
        public void run() {
            System.out.println("thread implements Runnable running...");
        }
    }



    public static void main(String[] args) {
        new MyThread01().start();
        new Thread(new MyThread02()).start();
        new Thread(()->{
            System.out.println("属于第二种的一种变种，是java 8 以后的一种写法，本质上还是实现runnable 接口");
       }).start();
    }
}
