package com.xyl.模式.组合模式;

import java.util.ArrayList;
import java.util.List;

public class Test {
    //客户端
    public static void main(String[] args) {
        //从大到小创建对象 大学 第一级
        University university=new University("清华大学","");
        //创建学院 Conllege第二级 Conllege叶子节点
        Conllege conllege1= new Conllege("计算机学院","");
        Conllege conllege2= new Conllege("信息工程学院","");
        //创建学院下的各个专业（系）
        conllege1.add(new Department("软件工程",""));
        conllege1.add(new Department("网络工程",""));
        conllege1.add(new Department("计算机科学与技术","是个老牌的专业"));

        conllege2.add(new Department("通讯工程","不好学"));
        conllege2.add(new Department("信息工程","挺好学"));
        //给大学添加学院
        university.add(conllege1);
        university.add(conllege1);
        System.out.println("======打印大学下的学院和专业=========");
        //打印大学下的学院和专业
        university.print();
//        System.out.println("======打印计算机学院专业=========");
//        conllege1.print();
    }
}

//Component 根节点，定义规范
abstract class OrganizationComponent{
    public String name;
    public String des;

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }
    //添加院系
    protected  void add(OrganizationComponent component){
        //叶子节点不能有此方法
//        throw   new UnsupportedOperationException();
    }
    //删除院系
    protected  void remove(OrganizationComponent component){
//        throw   new UnsupportedOperationException();
    }
    //叶子节点和非叶子节点都有
    protected  abstract void print();
}
//College非叶子节点 管理者 大学
class University extends OrganizationComponent{
    //存放学院 大学下面是学院
    List<OrganizationComponent> list=new ArrayList<>();
    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent component) {
        super.add(component);
        list.add(component);
    }

    @Override
    protected void remove(OrganizationComponent component) {
        super.remove(component);
        list.remove(component);
    }
    //输出大学包含的学院
    @Override
    protected void print() {
        System.out.println("---------"+name+"-------------");
        //输出大学下面的学院
        for (OrganizationComponent item:list) {
            item.print();
        }
    }
}
//College非叶子节点 管理者 学院
class Conllege extends OrganizationComponent{
    //存放系 学院下面是系
    List<OrganizationComponent> list=new ArrayList<>();
    public Conllege(String name, String des) {
        super(name, des);
    }
    //在实际业务中Conllege.add和University.add()不一定完全一样
    @Override
    protected void add(OrganizationComponent component) {
        super.add(component);
        list.add(component);
    }

    @Override
    protected void remove(OrganizationComponent component) {
        super.remove(component);
        list.remove(component);
    }
    //输出学院包含的专业
    @Override
    protected void print() {
        System.out.println("---------"+name+"-------------");
        //输出学院下的专业
        for (OrganizationComponent item:list) {
            item.print();
        }
    }
}

//系（专业） 叶子节点，只是被操作者 最小的组织
class Department extends OrganizationComponent{

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    protected void print() {
        System.out.println(name);
    }
}