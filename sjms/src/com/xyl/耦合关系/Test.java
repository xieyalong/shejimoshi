package com.xyl.耦合关系;


public class Test {
    public static void main(String[] args) {
    }
}

//class  B{}
//abstract class  C{}
//interface D{}
////继承关系,实现关系
//class A extends  C implements D{
//    //依赖关系 参数
//    public void run(B b){}
//    //依赖关系 变量
//    private  B b;
//    //依赖关系 返回值
//    public B getB() {
//        return b;
//    }
//
//    public void data() {
//        //依赖关系 局部变量
//        B b=new B();
//    }
//}


class  B{}
class  A{
    //组合关系 这种是不可分离的
    private B b=new B();
}

