package com.learning.other.copy;


/**
 * 直接拷贝：  Computer computerCopy = computer;
 * 直接把computer的引用地址赋值给computerCopy
 * 可以理解为computerCopy和computer是同一个对象，无论是computer还是computerCopy变化，另一个也会变化.
 * System.out.println(computerCopy == computer);=====true
 */

public class DirectCopy {


    public static void main(String[] args) {
        UsbInterface usb = new UsbInterface(1, "tab3");
        Computer computer = new Computer("华为", 2, usb);
        //复制对象
        Computer computerCopy = computer;
        computerCopy.setCount(10);
        computerCopy.setNameComputer("苹果");
        UsbInterface usbCopy = new UsbInterface(-1, "啊啊啊");
        computerCopy.setUsbInterface(usbCopy);
        usbCopy.setNumber(1000000000);

        System.out.println("原对象："+computer);
        System.out.println("复制后对象："+computerCopy);
    }
}


