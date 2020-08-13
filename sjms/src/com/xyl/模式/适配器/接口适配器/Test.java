package com.xyl.模式.适配器.接口适配器;

public class Test {
    public static void main(String[] args) {
        //使用
        new AbsAdapter(){
            //只需要关心自己需要的方法即可
            @Override
            public void m1() {
                super.m1();
            }
        };
    }
}

interface Itfc{
    void m1();
    void m2();
    void m3();
    void m4();
}
//默认全部实现 想用哪个就使用哪个
abstract  class AbsAdapter implements Itfc{
    @Override
    public void m1() {
        System.out.println("使用了m1的方法");
    }
    @Override
    public void m2() {}
    @Override
    public void m3() {}
    @Override
    public void m4() {}
}
