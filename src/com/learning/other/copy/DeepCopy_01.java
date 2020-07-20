package com.learning.other.copy;

/**
 * 浅拷贝：构造方法实现浅拷贝
 */
public class DeepCopy_01 {



    public static void main(String[] args) throws CloneNotSupportedException {
        UsbInterfaceClone usb = new UsbInterfaceClone(1, "tab3");
        ComputerCloneable computer = new ComputerCloneable("华为", 2, usb);

        ComputerCloneable computerCopy = (ComputerCloneable)computer.clone();
        computer.setCount(100);
        computer.setNameComputer("小米");
        usb.setNumber(0);
        usb.setType("没有usb");
        System.out.println("改变原对象后,原对象："+computer);
        System.out.println("改变原对象后,复制对象："+computerCopy);
    }
}


