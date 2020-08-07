package com.xyl.原型模式;

public class 需求 {
}
class  Client{
    public static void main(String[] args) {
        Sheep sheep=new Sheep("tom",1,"白色");
        //每次获取原来的数据然后在set上去，如果很多这样用是不行的
        new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
    }
}

//羊
class  Sheep{
    private  String name;
    private int age;
    private  String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}