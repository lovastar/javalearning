package com.learning.other.copy;

public class Computer {
    private String nameComputer;
    private Integer count;
    private UsbInterface usbInterface;

    public Computer(String nameComputer, Integer count, UsbInterface usbInterface) {
        this.nameComputer = nameComputer;
        this.count = count;
        this.usbInterface = usbInterface;
    }

    public Computer(Computer computer) {
        this.nameComputer = computer.nameComputer;
        this.count = computer.count;
        this.usbInterface = computer.usbInterface;
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

    public UsbInterface getUsbInterface() {
        return usbInterface;
    }

    public void setUsbInterface(UsbInterface usbInterface) {
        this.usbInterface = usbInterface;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "nameComputer='" + nameComputer + '\'' +
                ", count=" + count +
                ", usbInterface=" + usbInterface +
                '}';
    }
}

class UsbInterface {
    private Integer number;
    private String type;

    public UsbInterface(Integer number, String type) {
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
    public String toString() {
        return "UsbInterface{" +
                "number=" + number +
                ", type='" + type + '\'' +
                '}';
    }
}



