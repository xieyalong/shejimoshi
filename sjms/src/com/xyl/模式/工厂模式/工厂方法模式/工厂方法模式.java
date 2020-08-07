package com.xyl.模式.工厂模式.工厂方法模式;

import java.time.Year;
import java.util.Scanner;

public class 工厂方法模式 {
    //客户端
    public static void main(String[] args) {
        //北京口味的各种披萨
//        DingDanFactory factory=  new BJDingDanFactory ();
        DingDanFactory factory2=  new LDDingDanFactory ();
    }
}

//订单
abstract class DingDanFactory{
    public DingDanFactory() {
        String type=null;
        Pizz pizz=null;
        do {
            type=getType();
            //调用抽象方法
            pizz= cretePizz(type);
            //输出披萨制作过程
            if (null!=pizz){
                pizz.prepare();
                pizz.kongKao();
                pizz.qieGe();
                pizz.daBao();
            }else{
                System.out.println("订购失败");
            }

        }while (true);
    }
    //定义一个工厂的抽象类
    abstract Pizz cretePizz(String type);

    //获取用户输入的披萨种类
    private   String getType(){
        Scanner input =new Scanner(System.in);
        System.out.println("输入要订购的披萨种类 1是北京榴莲披萨 2是伦敦榴莲披萨");
        String name=input.nextLine();
        return name;
    }
}
//北京订单榴莲披萨
class BJDingDanFactory extends DingDanFactory{

    @Override
    Pizz cretePizz(String type) {
        Pizz pizz=null;
        if ("1".equals(type)){
            pizz=new BJLiuLianPizz();
            pizz.name="北京榴莲披萨";
        }else{
            System.out.println("目前北京只有榴莲披萨");
        }
        return pizz;
    }
}
//伦敦订单榴莲披萨
class LDDingDanFactory extends DingDanFactory{

    @Override
    Pizz cretePizz(String type) {
        Pizz pizz=null;
        if ("2".equals(type)){
            pizz=new LDLiuLianPizz();
            pizz.name="伦敦榴莲披萨";
        }else{
            System.out.println("目前伦敦只有榴莲披萨");
        }
        return pizz;
    }
}
//披萨基类 提供方
abstract class  Pizz{
    //披萨名称
    protected  String name;
    //原材料 不同的披萨是不一样的所以要抽象方法
    //烘烤，切割，打包，都是一样的
    public abstract  void prepare();

    public void  kongKao(){
        System.out.println(name+" 烘烤");
    }
    public  void  qieGe(){
        System.out.println(name+" 切割");
    }
    public void daBao(){
        System.out.println(name+" 打包");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BJLiuLianPizz extends Pizz{
    @Override
    public void prepare() {
        System.out.println("北京的榴莲披萨员材料");
    }
}
class BJZhiShiPizz extends Pizz{
    @Override
    public void prepare() {
        System.out.println("北京的芝士披萨员材料");
    }
}
class LDLiuLianPizz extends Pizz{
    @Override
    public void prepare() {
        System.out.println("伦敦的榴莲披萨员材料");
    }
}
class LDZhiShiPizz extends Pizz{
    @Override
    public void prepare() {
        System.out.println("伦敦的芝士披萨员材料");
    }
}

