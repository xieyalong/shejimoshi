package com.xyl.模式.访问者模式.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ObjectStructure os=new ObjectStructure();
        os.attache(new Man());
        os.attache(new Woman());
        System.out.println("------同时给男女评价成功------");
        //给的成功
        Success success=new Success();
        os.display(success);

        System.out.println("------同时给男女评价失败------");
        //给的失败
        Fail fail=new Fail();
        os.display(fail);

        System.out.println("------给男评价成功------");
        os=new ObjectStructure();
        os.attache(new Man());
        success=new Success();
        os.display(success);
        System.out.println("------给女评价成功------");
        os=new ObjectStructure();
        os.attache(new Woman());
        fail=new Fail();
        os.display(fail);
    }
}


//1，原型截图
//2，技术方案

/**
 * 角色分析
 * 访问者（评价类） 分男女性观众评价评价结果为成功，失败等结果
 * 访问元素（歌手），歌手得到成功，失败等结果
 * 访问者可以抽象出观众类，
 */


//访问者类（观众类）
// 观众是访问者（给出测评结果），歌手是访问元素(得到成功和失败结果)
// 观众分：男性观众和女性观众，小孩，老人等等
// 访问元素份（歌手）：歌手评价是成功，失败，直接晋级等等
//观众是抽象的 划分出男性和女性
//歌手是人也是抽象的 划分出成功和失败
abstract  class  Action{
    //男性的测评
    public abstract  void getManResult(Man man);
    //女性的测评
    public abstract  void getWomanResult(Woman woman);
}

//访问者实现类 晋级  成功
//一个成功对应一个男的和一个女的，如果多了一个
class Success extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价该歌手很成功");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人给的评价该歌手很成功");
    }
}


//访问者实现类 晋级 失败
//一个失败对应一个男的和一个女的
class Fail extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价该歌手很失败");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人给的评价该歌手很失败");
    }
}


//访问元素（歌手）
abstract class Person{
    //提供一个方法让访问者访问
    public abstract  void  accept(Action action);
}



//元素实现类（观众类型） 男人
class  Man extends Person{

    //接受一个访问者
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
//元素实现类（观众类型） 女人
//说明
//1，这里使用到了双分派
//双分派：首先在客户端的程序中，将具体的状态作为参数传递到了woman中，完成了第一次分派
//然后woman类调用作为参数的"具体方法"中的get（getWomanResult）同时将自己的this作为参数传入，完成了第二次分派
//双分派达到了解耦
//元素实现类 女人
class  Woman extends Person{
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
//允许访问者访问元素
//数据结构 管理很多人（男人，女人）
class ObjectStructure{
    //可能是类，可能是集合
    private List<Person> persons=new LinkedList<>();
    //增加到集合中
    public void attache(Person p){
        persons.add(p);
    }
    public void detach(Person p){
        persons.remove(p);
    }
    //显示测评情况
    public void display(Action action){
        for (Person p:persons){
            p.accept(action);
        }
    }
}






