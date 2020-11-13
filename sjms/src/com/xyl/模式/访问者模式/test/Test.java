package com.xyl.模式.访问者模式.test;

public class Test {

}

//访问者 评价
abstract  class  Action{
    //男性的测评
    public abstract  void getManResult(Man man);
    //女性的测评
    public abstract  void getWomanResult(Woman woman);
}

//访问者实现类 晋级  成功
//一个成功对应一个男的和一个女的，如果多了一个
class Success extends Action{

}
//访问者实现类 晋级 失败
//一个失败对应一个男的和一个女的
class Fail extends Action{

}
//待定 如果多了一个评价 原来的代码不用改变
class Wait extends Action{

}

//元素 接收访问者
abstract class Person{

}

//元素实现类 男人
class  Man extends Person{}
//元素实现类 女人
class  Woman extends Person{}
//允许访问者访问元素
class ObjectStructure{

}