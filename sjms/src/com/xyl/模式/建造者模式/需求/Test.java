package com.xyl.模式.建造者模式.需求;

public class Test {
    public static void main(String[] args) {
        CreteHouse house=new FangZi();
        house.build();

        //可以通过new 可以生成出不同的产品
        StringBuffer sb=new StringBuffer();
        sb=new StringBuffer(3333);
        sb=new StringBuffer("aaaaaa");
        //创造者 虽然它调用的是父类的实现，
        //但也间接的实现了Appendable.append（）
        sb.append("bbb");
    }
}
abstract  class CreteHouse{
    //地基
    public abstract  void diJi();
    //砌墙
    public abstract void qieQiang();
    //封顶
    public  abstract void fengDing();
    //建造
    public void build(){
        diJi();
        qieQiang();
        fengDing();
    }
}
//建造普通房子
class FangZi extends CreteHouse{
    @Override
    public void diJi() {
        System.out.println("普通房子打地基");
    }
    @Override
    public void qieQiang() {
        System.out.println("普通房子打砌墙");
    }
    @Override
    public void fengDing() {
        System.out.println("普通房子打封顶");
    }
}
