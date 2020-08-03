package com.learning.annotation;

@Table(name="xxxx")
public class Student {
    @NotNull("aaaaa")
    private String name ;
    @NotNull("bbbb")
    private Integer id ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
