package com.xyl.yuanze_yilaidaozhi;

public class yilaidaozhigai {
    public static void main(String[] args) {
        new Person1().receive(new Email1());
        new Person1().receive(new Weixin1());
    }
}

//好处在于，细节变了，底层依然没有改变，如增加了微信，qq的短信
interface  IReceiver{
    String getInfo();
}

class Person1{
    //iReceiver是谁我就接受的谁
    public void receive(IReceiver iReceiver){
        System.out.println(iReceiver.getInfo());
    }
}

class Email1 implements IReceiver{
    @Override
    public String getInfo(){
        return  "电子邮件信息：邮件消息";
    }
}
class  Weixin1 implements  IReceiver{
    @Override
    public String getInfo() {
        return  "电子邮件信息：微信消息";
    }
}
