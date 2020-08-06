//package com.xyl.模式.单例模式;
//
//public class 静态代码块饿汉式 {
//    public static void main(String[] args) {
//    }
//}
///**
// * 静态常量饿汉式
// */
//class Singleton2{
//    //1，构造私有化
//    private  Singleton2(){}
//    //2，在静态代码块里面实例化对象
//    private    static Singleton2 instance;
//    static{
//        instance=new Singleton2();
//    }
//
//    //3,对外提供一个静态，共有的实例方法
//    public static Singleton2 getInstance(){
//        return instance;
//    }
//}
//
