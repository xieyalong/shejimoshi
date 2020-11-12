package com.xyl.模式.模版模式.规范;

public class Test {
    public static void main(String[] args) {
        Abs abs=new Z();
        //运行大的流程
        abs.run();
    }
}

abstract class Abs{
    protected void run1(){}
    abstract protected void run2();
    protected void  run3(){}
    //执行流程 不被子类实现
    final void run(){
        run1();
        if (isRun())run2();
        run3();
    }
    //钩子方法控制某个流程段
    boolean isRun(){
        return  true;
    }
}
//run1 有子类来实现
class Z extends Abs{
    @Override
    protected void run2() {}

    @Override
    boolean isRun() {
        return false;
    }
}
