package com.xyl.模式.工厂模式.简单工厂模式;

import java.util.Scanner;


public class 简单工厂模式 {

}
//============改进后==================
//客户端
class KeHuDuan{
    public static void main(String[] args) {
        //订单
        new DingDan().setFactory(new SimpleFactory());
    }
}
//工厂类 让使用方直接使用工厂，你要什么样的披萨，工厂就生产什么样的披萨
class SimpleFactory{
    //你给我一个订购的类型，我创建一个对象给你返回
    //以后只要新加的 只需要修改这里就可以，不需要修改其他地方
    public  Pizz createPizz(String type){
        Pizz pizz=null;
        if ("1".equals(type)){
            pizz= new ZhiShiPizz();
            pizz.setName("芝士披萨");
        }else if ("2".equals(type)){
            pizz=new LiulianPizz();
            pizz.setName("榴莲披萨");
        }else  if("3".equals(type)){//增加香蕉披萨
            pizz=new XiangJiaoPizz();
            pizz.setName("香蕉披萨");
        }
        return pizz;
    }
    //静态的简单工厂模式
    public static   Pizz createPizz2(String type){
        Pizz pizz=null;
        if ("1".equals(type)){
            pizz= new ZhiShiPizz();
            pizz.setName("芝士披萨");
        }else if ("2".equals(type)){
            pizz=new LiulianPizz();
            pizz.setName("榴莲披萨");
        }else  if("3".equals(type)){//增加香蕉披萨
            pizz=new XiangJiaoPizz();
            pizz.setName("香蕉披萨");
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
//芝士披萨
class ZhiShiPizz extends Pizz{

    @Override
    public void prepare() {
        System.out.println(name+" 给芝士披萨准备原材料");
    }
}
//榴莲披萨
class LiulianPizz extends Pizz{

    @Override
    public void prepare() {
        System.out.println(name+" 给榴莲披萨准备原材料");
    }
}

//新增的 香蕉披萨
class XiangJiaoPizz extends Pizz{

    @Override
    public void prepare() {
        System.out.println(name+" 给香蕉披萨准备原材料");
    }
}
//订单披萨  使用方
class DingDan{
    public void setFactory(SimpleFactory factory) {
        String type=null;
        Pizz pizz=null;
        do {
            type=getType();
            pizz= factory.createPizz(type);
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

    //获取用户输入的披萨种类
    private   String getType(){
        Scanner input =new Scanner(System.in);
        System.out.println("输入要订购的披萨种类 1是芝士披萨 2是榴莲披萨 3是香蕉披萨");
        String name=input.nextLine();
        return name;
    }
}
//============改进前==================
////客户端
//class KeHuDuan{
//    public static void main(String[] args) {
//        //订单
//        new DingDan();
//    }
//}
////披萨基类 提供方
//abstract class  Pizz{
//    //披萨名称
//    protected  String name;
//    //原材料 不同的披萨是不一样的所以要抽象方法
//    //烘烤，切割，打包，都是一样的
//    public abstract  void prepare();
//
//    public void  kongKao(){
//        System.out.println(name+" 烘烤");
//    }
//    public  void  qieGe(){
//        System.out.println(name+" 切割");
//    }
//    public void daBao(){
//        System.out.println(name+" 打包");
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
////芝士披萨
//class ZhiShiPizz extends Pizz{
//
//    @Override
//    public void prepare() {
//        System.out.println(name+" 给芝士披萨准备原材料");
//    }
//}
////榴莲披萨
//class LiulianPizz extends Pizz{
//
//    @Override
//    public void prepare() {
//        System.out.println(name+" 给榴莲披萨准备原材料");
//    }
//}
//
////新增的 香蕉披萨
//class XiangJiaoPizz extends Pizz{
//
//    @Override
//    public void prepare() {
//        System.out.println(name+" 给香蕉披萨准备原材料");
//    }
//}
////订单披萨  使用方
//class DingDan{
//    public DingDan() {
//        Pizz pizz=null;
//        do {
//            String type=getType();//披萨种类
//            if ("1".equals(type)){
//                pizz= new ZhiShiPizz();
//                pizz.setName("芝士披萨");
//            }else if ("2".equals(type)){
//                pizz=new LiulianPizz();
//                pizz.setName("榴莲披萨");
//            }else  if("3".equals(type)){//增加香蕉披萨
//                pizz=new XiangJiaoPizz();
//                pizz.setName("香蕉披萨");
//            }else {
//                System.out.println("没有你要订购的披萨 退出");
//                break;
//            }
//            //输出披萨制作过程
//            pizz.prepare();
//            pizz.kongKao();
//            pizz.qieGe();
//            pizz.daBao();
//        }while (true);
//    }
//    //获取用户输入的披萨种类
//    public  String getType(){
//        Scanner input =new Scanner(System.in);
//        System.out.println("输入要订购的披萨种类 1是芝士披萨 2是榴莲披萨 3是香蕉披萨");
//        String name=input.nextLine();
//        return name;
//    }
//}
