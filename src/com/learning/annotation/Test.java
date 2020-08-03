package com.learning.annotation;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setId(1);
        stu.setName("liuxx");
        TableAnnotationExplain.explainNotNullAnnotation(stu);
    }
}
