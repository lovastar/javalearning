package com.learning.other.copy;

/**
 * 浅拷贝：需要克隆的对象实现Cloneable接口，然后重写Object类中的clone()方法
 *
 * 注意
 *        一个对象如果没有实现cloneable接口并且重新Object类中的clone方法
 *        是没有办法直接调用Object类中的clone方法的。
 *        原因，因为clone方法是protected的，
 *        自己的类和Object类不是同一个包，所以无法访问
 */
public class ShallowCopy_02 {

    

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


