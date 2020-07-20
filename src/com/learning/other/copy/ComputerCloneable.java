package com.learning.other.copy;

public class ComputerCloneable implements Cloneable{
    private String nameComputer;
    private Integer count;
    private UsbInterfaceClone usbInterface;

    public ComputerCloneable(String nameComputer, Integer count, UsbInterfaceClone usbInterface) {
        this.nameComputer = nameComputer;
        this.count = count;
        this.usbInterface = usbInterface;
    }


    public String getNameComputer() {
        return nameComputer;
    }

    public void setNameComputer(String nameComputer) {
        this.nameComputer = nameComputer;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public UsbInterfaceClone getUsbInterface() {
        return usbInterface;
    }

    public void setUsbInterface(UsbInterfaceClone usbInterface) {
        this.usbInterface = usbInterface;
    }

    @Override
    public String toString() {
        return "ComputerCloneable{" +
                "nameComputer='" + nameComputer + '\'' +
                ", count=" + count +
                ", usbInterface=" + usbInterface +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //当前对象复制一个新对象
        Object obj = super.clone();
        ComputerCloneable c = (ComputerCloneable)obj;
        //当前对象的实例复制一个新的对象，然后赋值给新对象的实例
        c.usbInterface= (UsbInterfaceClone)c.getUsbInterface().clone();
        return obj ;
    }
}

class UsbInterfaceClone  implements Cloneable {
    private Integer number;
    private String type;

    public UsbInterfaceClone(Integer number, String type) {
        this.number = number;
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "UsbInterfaceClone{" +
                "number=" + number +
                ", type='" + type + '\'' +
                '}';
    }
}



