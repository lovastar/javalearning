package com.learning.annotation;

public class D02_Relfact {
    public static void main(String[] args) throws ClassNotFoundException {
        getClassWays();
    }

    /**
     * 获取一个Class对象的三种方式
     * 每个类有且只有一个class对象，
     * @throws ClassNotFoundException
     */
    public static void getClassWays() throws ClassNotFoundException {
        //使用类.class
        Class c1 = Person.class;

        //使用Class.forName()
        Class c2 = Class.forName("com.learning.annotation.Person");

        Person p = new Person();
        Class c3 = p.getClass();


        System.out.println(c1.hashCode());
        System.out.println(c1.hashCode());
        System.out.println(c1.hashCode());

        System.out.println(c1==c2);
    }



}

class Person {
    private String name;
}
