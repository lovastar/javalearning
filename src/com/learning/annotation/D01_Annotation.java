package com.learning.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class D01_Annotation {
    @MyAnnotation
    public void testAnnotation() {

    }

    @MyAnnotation01("xxx")
    public void testAnnotation01() {

    }


}


/**
 * 一般定义注解的时候需要使用元注解：@Target @Retention 用来指定他的作用域和生命周期
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {

    String name() default "";  //name 表示注解的属性名称 ，String 表示name属性的值的类型 ;
    //如果不加default ，那么在使用 @myAnnotation时候，必须指定name的值，如果加了，则可以不加

    int age() default 0;

    String[] schools() default {"北京大学", "南京大学"};
}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation01 {

    String value() default ""; //当注解只有一个属性的时候，属性名字推荐用value ，这样写的时候可以省略属性名
}