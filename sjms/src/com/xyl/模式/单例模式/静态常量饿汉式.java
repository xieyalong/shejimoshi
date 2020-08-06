//package com.xyl.模式.单例模式;
//
//public class 静态常量饿汉式 {
//    public static void main(String[] args) {
//        //调用
//        Singleton singleton= Singleton.getInstance();
//    }
//}
//
///**
// * 静态常量饿汉式
// */
//class Singleton{
//    //1，构造私有化
//    private  Singleton(){}
//    //2，本类内部创建私有静态对象实例
//    private  final  static Singleton instance=new Singleton();
//    //3,对外提供一个静态，共有的实例方法
//    public static Singleton getInstance(){
//        return instance;
//    }
//}