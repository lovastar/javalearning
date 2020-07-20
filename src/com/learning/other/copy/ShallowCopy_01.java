package com.learning.other.copy;

import sun.applet.Main;

/**
 * 浅拷贝：构造方法实现浅拷贝
 */
public class ShallowCopy_01 {



    public static void main(String[] args) {
        UsbInterface usb = new UsbInterface(1, "tab3");
        Computer computer = new Computer("华为", 2, usb);

        Computer computerCopy = new Computer(computer);//通过构造方法实现浅拷贝
        computer.setCount(100);
        computer.setNameComputer("小米");
        usb.setNumber(0);
        usb.setType("没有usb");
        System.out.println("改变原对象后,原对象："+computer);
        System.out.println("改变原对象后,复制对象："+computerCopy);
    }
}


