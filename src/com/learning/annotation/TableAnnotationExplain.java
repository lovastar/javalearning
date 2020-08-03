package com.learning.annotation;


import java.lang.reflect.Field;

public class TableAnnotationExplain {

    public static void explainTableAnnotation(Object obj) {
        Class clazz = obj.getClass();
        //判断是否加了当前注解注解
        if (clazz.isAnnotationPresent(Table.class)) {
            //获取注解对应的值
            Table table = (Table) clazz.getAnnotation(Table.class);

            System.out.println(table.name());
        }

    }


    public static void explainNotNullAnnotation(Object obj) {
        Class clazz = obj.getClass();
        Field[] fields =  clazz.getDeclaredFields();
        for(Field f:fields) {
            if (f.isAnnotationPresent(NotNull.class)) {
                NotNull notnull = (NotNull) f.getDeclaredAnnotation(NotNull.class);
                System.out.println(notnull.value());
            }
        }
    }
}
