package com.xyl.yuanze_yilaidaozhi;

public class yilaidaozhi {
    public static void main(String[] args) {
        new Person().receive(new Email());
        new Person().receive(new WeiXin());
    }
}
/**
 * 完成Person接收消息的功能
 * 以下方式优缺点
 * 1，简单，比较容易想到
 * 2，如果我们获取的对象是微信，短信，qq，同时Person也要增加微信，短信的方法
 */
class Person{
    //email消息
    public void receive(Email info){
        System.out.println(info.getInfo());
    }
    public void receive(WeiXin info){
        System.out.println(info.getInfo());
    }
}
class Email{
    public String getInfo(){
        return  "电子邮件信息：邮件消息";
    }
}
class WeiXin{
    public String getInfo(){
        return  "电子邮件信息：微信消息";
    }
}
