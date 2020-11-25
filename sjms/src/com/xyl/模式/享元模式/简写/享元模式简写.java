package com.xyl.模式.享元模式.简写;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class 享元模式简写 {
    private static final String colors[] =
            { "Red", "Green", "Red", "Green",  };
    public static void main(String[] args) {
        for(int i=0; i <colors.length; ++i) {
            Circle circle =ShapeFactory.getCircle(colors[i]);
            circle.draw();
        }
    }
}
//绘制圆形
class Circle {
    private String color;
    public Circle(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("圆的颜色: " + color);
    }
}

class ShapeFactory {
    private static final Map<String, Circle> circleMap = new Hashtable<String, Circle>();

    public static Circle getCircle(String color) {
        Circle circle =circleMap.get(color);
        //判断对象是否存在，如果存在不在创建
        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println(color+"色对象已经存在");
        }
        return circle;
    }
}