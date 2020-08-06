package com.xyl.迪米特法则;

import java.util.ArrayList;
import java.util.List;

////改进后
//public class Test {
//    //客户端
//    public static void main(String[] args) {
//
//        ZongBuGuanLi zongBuGuanLi=new ZongBuGuanLi();
//        //输出学院和总部的员工
//        zongBuGuanLi.printAll(new XueYuanGuanLi());
//    }
//}
//
//
////学院管理类
//class XueYuanGuanLi{
//    List<String> list=new ArrayList<>();
//    private   List<String> getList(){
//        for (int i = 0; i < 10; i++) {
//            list.add("学院员工"+i);
//        }
//        return list;
//    }
//    //暴露自己的方法，让别人去调用，具体实现在我自己的类中实现
//    public void printAll(){
//        System.out.println("==========学院员工======================");
//        getList();
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//        }
//    }
//}
////学校总部管理类
//class ZongBuGuanLi{
//    //直接朋友
//    List<String> list=new ArrayList<>();
//    private   List<String> getList(){
//        for (int i = 0; i < 5; i++) {
//            list.add("总部员工"+i);
//        }
//        return list;
//    }
//    //printAll(XueYuanGuanLi guanLi)写法是直接朋友
//    //输出学院和总部的员工
//    void printAll(XueYuanGuanLi guanLi){
//        //调用别人的类暴露出来的方法 这样符合迪米特法则，不去具体的实现别的类的方法
//        guanLi.printAll();
//        System.out.println("==========总部员工======================");
//        getList();
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//        }
//    }
//}






//改进前
public class Test {
    //客户端
    public static void main(String[] args) {

        ZongBuGuanLi zongBuGuanLi=new ZongBuGuanLi();
        //输出学院和总部的员工
        zongBuGuanLi.printAll(new XueYuanGuanLi());
    }
}


//学院管理类
class XueYuanGuanLi{
    List<String> list=new ArrayList<>();
    public  List<String> getList(){
        for (int i = 0; i < 10; i++) {
            list.add("学院员工"+i);
        }
        return list;
    }
}
//学校总部管理类
class ZongBuGuanLi{
    //直接朋友
    List<String> list=new ArrayList<>();
    public  List<String> getList(){
        for (int i = 0; i < 5; i++) {
            list.add("总部员工"+i);
        }
        return list;
    }
    //printAll(XueYuanGuanLi guanLi)是直接朋友
    //输出学院和总部的员工
    void printAll(XueYuanGuanLi guanLi){
        //这样的写法不是直接朋友，
        //因为在总部的类中，去具体实现学院类中的具体方法
        //或者List<XueYuan> list=guanLi.getList()也不是直接朋友
        //像这样的违反了迪米特法则，以局部变量的方式出现了方法中
        //因为这不是最小知道原则，你不要在我的类中具体实现你的方法，
        System.out.println("==========学院员工======================");
        List<String> guanli_list=guanLi.getList();
        for (int i = 0; i <guanli_list.size(); i++) {
            System.out.println(guanli_list.get(i));
        }
        System.out.println("==========总部员工======================");
        getList();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}