package com.learning.annotation;

@Table(name="xxxxxx")
public class TableAnnotationExplain {

    public static  void explainTableAnnotation(Object obj){
        Class clazz=obj.getClass();
        System.out.println( clazz.isAnnotationPresent(clazz));

    }
}
