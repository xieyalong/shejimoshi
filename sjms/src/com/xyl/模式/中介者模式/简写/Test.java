package com.xyl.模式.中介者模式.简写;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Mediator mediator=new Mediator();
        mediator.add("a",new Colleague());
        mediator.add("b",new Colleague());
        mediator.handler("a");
    }
}
//中介者类（这里简写 没有写抽象类）
class Mediator {
    Map<String,Colleague> map=new HashMap<>();
    //加入管理同事类
    public  void add(String key,Colleague user){
        map.put(key,user);
    }

    //处理各个同事类之间的业务逻辑
    public void  handler(String key){}

}
//同事类（这里简写 没有写抽象类）
class Colleague {
}