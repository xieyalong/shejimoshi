//package com.xyl.模式.单例模式;
//
//public class 不安全懒汉式 {
//    public static void main(String[] args) {
//
//    }
//
//}
//class Singleton3{
//    //1，创建私有构造
//    private Singleton3(){}
//    //2,私有静态的变量
//    private static  Singleton3 instance;
//    //3,共有静态的方法 在使用的时候才去创建对象
//    public static Singleton3 getInstance() {
//        if (null==instance){
//            instance=new Singleton3();
//        }
//        return instance;
//    }
//}