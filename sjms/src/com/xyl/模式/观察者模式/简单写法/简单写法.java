package com.xyl.模式.观察者模式.简单写法;


import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class 简单写法 {
    public static void main(String[] args) {
        //使用场景 a类通知b类
        //b类中注册观察者 a类中发送数据

        //主题类
        Subject subject=new Subject();

        //注册
        new B("k",subject);

        //发送
        new A(subject).send("k","你好啊");
    }

}
class A{
    Subject subject;
    public A(Subject subject) {
        this.subject = subject;
    }
    public void send(String key,String data){
        subject.notifyObserver(key,data);
    }
}

class B{
    Subject subject;
    public B(String key,Subject subject) {
        this.subject = subject;
        subject.register(key,new  BObserver());
    }
    //内部的观察者
    class  BObserver implements  Observer{

        @Override
        public void update(String data) {
            System.out.println("接受信息="+data);
        }
    }
}
//主体类
class Subject {
    private Map<String ,Observer> map = new  Hashtable();

    public void register(String key,Observer observer) {
        map.put(key,observer);
    }

    public void remove(String key,Observer observer) {
        map.remove(key);
    }
    public void notifyObserver(String key,String data) {
        map.get(key).update(data);
    }
}
//观察者Observer
interface  Observer{
    void update(String data);
}
