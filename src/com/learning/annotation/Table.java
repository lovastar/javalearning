package com.learning.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
注解：
一、元注解
 作用：解释其他注解。
 java 的元注解：
 @Target ：作用在什么地方：类，方法，字段等 ，所有的作用域定义在ElementType枚举中
 @Retention：生命周期：source(源代码)<class<runtime   定义在retentionPolicy枚举类中 .一般都写runtime，不写默认源码级别
 @Documented：
 @Inherited
 * 一般定义注解的时候需要使用元注解：@Target @Retention 用来指定他的作用域和生命周期
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {

    String name() default "";  //name 表示注解的属性名称 ，String 表示name属性的值的类型 ;
    //如果不加default ，那么在使用 @myAnnotation时候，必须指定name的值，如果加了，则可以不加
    // 当注解只有一个属性的时候，属性名字推荐用value ，这样写的时候可以省略属性名

    int age() default 0;

    String[] schools() default {"北京大学", "南京大学"};
}


