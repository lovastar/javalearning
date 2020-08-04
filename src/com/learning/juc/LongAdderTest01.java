package com.learning.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;


public class LongAdderTest01 {

    public static void main(String[] args) throws InterruptedException {

        LongAdder adder = new LongAdder();
        adder.add(2);
    }


}
