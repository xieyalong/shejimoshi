package com.xyl.yuanze_jiekougeli_gai;

/**
 * 接口隔离
 */
public class JieKouGeLi {
    public static void main(String[] args) {
        B b=new B();
    }
}

//把Itf拆分成两个
interface Itf{
    void run1();
}

interface Itf2{
    void run2();
    void run3();
}

//A想实现Itf所有方法
class  A implements Itf,Itf2{
    @Override
    public void run1() { }
    @Override
    public void run2() {}
    @Override
    public void run3() {}
}

//B只实现了Itf.run1()方法
class B implements Itf{
    @Override
    public void run1() {}
}








