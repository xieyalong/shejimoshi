package com.xyl.test;

import com.xyl.KT.KS;
import com.xyl.KT.KUser;
import com.xyl.KT.SP;

import java.io.PrintStream;
import java.util.Calendar;


public class Test {
    public static void main(String[] args) {
    }
}
class  B{}
class A{
    //依赖关系 参数
    public void run(B b){}
    //聚合关系 成员变量和set
    private  B b;
    public void setB(B b) {
        this.b = b;
    }
    //组合关系 直接new
    private  B b1=new B();
}

