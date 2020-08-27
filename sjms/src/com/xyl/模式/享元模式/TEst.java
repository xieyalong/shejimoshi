package com.xyl.模式.享元模式;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TEst {
    public static void main(String[] args) {
        WebSiteFactory factory=new WebSiteFactory();
        //客户要以新闻形式发布的网站
       WebSite xinwen=factory.getWebSite("新闻");
        xinwen.use();
    }
}
//网站抽象类
abstract class   WebSite{
    abstract public void use();
}
//具体网站类
class ConcreteWebSite extends WebSite{
    public String type="";//网站发布的类型

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println("网站的发布形式为="+type);
    }
}

//网站工厂类 根据需要返回一个网站
class WebSiteFactory{
    //对象池
    HashMap<String,ConcreteWebSite> pool=new HashMap<>();
    //根据网站类型，返回一个网站，如果没有就创建一个网站并放到池中并返回
    public   WebSite getWebSite( String type){
        //如果没有，就创建一个网站放到池中
        if (!pool.containsKey(type)){
            pool.put(type,new ConcreteWebSite(type));
        }
        return pool.get(type);
    }
    //查看对象池的数量
    public int getWebSiteCount(){
        return  pool.size();
    }
}
 class Test2{
    public static void main(String[] args) {
    }
}