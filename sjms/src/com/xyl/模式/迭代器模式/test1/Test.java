package com.xyl.模式.迭代器模式.test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        //遍历所有数据
        OutputImpl output=new  OutputImpl();
        output.prinCollege();
    }
}
//完成对所有学院的输出
//这个类写不写都可以，
// 主要是为了在main()中运行方便
class OutputImpl{
    //大学集合
    List<College> collegeList;
    public OutputImpl() {
        //模拟把数据初始化掉

        //创建数据集合（大学集合）
        collegeList=new ArrayList<College>();
        //增加计算机学院
        collegeList.add(new ComputeColleage());
        //增加信息学院
        collegeList.add(new InfoCollege());
    }
    //遍历学院
    public  void prinCollege(){
        //从collegeList取出所有学院,
        // collegeList.iterator()=java中list已经实现了Iterator
        Iterator<College> iterator=collegeList.iterator();
        //判断是否有下一个
        while (iterator.hasNext()){
            //取出学院
            College college=iterator.next();
            System.out.println("=========="+college.getName()+"==========");

            //得到系的迭代器，
            // creteIterator()已经在子类中把数据传递给了对应的迭代器并返回了迭代器对象
            Iterator itemIterator=college.creteIterator();
            //迭代器遍历系的数据
            printDepartment(itemIterator);
        }
    }
    //遍历系
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department department=(Department)iterator.next();
            System.out.println(department.name+"---"+department.desc);
        }
    }

}

//系（元素类）  本项目目的：遍历大学下面学院的所有系
class Department{
    public String name;//系名
    public  String desc;//系描述

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}

//迭代器 计算机学院
//迭代器必须有个数组或者稽核来存储元素
//这里我们需要知道Department是怎样的方式存放 如数组 list
class ComputerConllegeIterator implements Iterator{
    Department[] departments;
    int positon=0;//index 遍历的位置
    //接受外来数据的传递
    public ComputerConllegeIterator(Department[] departments) {
        this.departments = departments;
    }

    //判断是否还有下一个元素
    //先hasNext在next 顺序不能颠倒
    @Override
    public boolean hasNext() {
        //索引超出数组长度 或者数组没有数据 返回false
        if (positon>=departments.length||departments[positon]==null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Department department=departments[positon];
        positon+=1;
        //返回当前元素
        return department;
    }
    //删除默认不实现
    @Override
    public void remove(){}
}
//迭代器 信息工程学院
class InfoConlleageIterator implements  Iterator{
    //信息工程学院是一list方式来储存系
    List<Department> departmentList;
    int index=-1;//索引

    public InfoConlleageIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    //判断是否有下一个
    @Override
    public boolean hasNext() {
        if (index>=departmentList.size()-1){
            return false;
        }
        index++;
        return true;
    }

    @Override
    public Object next() {
        Department department=departmentList.get(index);
        return department;
    }

    @Override
    public void remove() { }
}

//大学  数据抽象类
// （不对外暴露，只是把数据生成给迭代器即可，这里的数据可以认为是sql的或者其他得到的数据）
//核心思想：把数据给迭代器供其操作
interface  College{
    //获取系名称
    String getName();
    //增加元素
    void  addDepartment(String name,String desc);
    //返回一个迭代器，遍历
    Iterator creteIterator();
}

//计算机学院(数据类的具体子类)
class  ComputeColleage implements College{
    Department[] departments;
    int numOfDepartment=0;//保存当前数组的对象个数

    public ComputeColleage() {
        //模拟把学院的系初始化
        departments=new Department[5];
        addDepartment("java","java专业");
        addDepartment("php","php专业");
        addDepartment("Python","Python专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department=new Department(name,desc);
        departments[numOfDepartment]=department;
        numOfDepartment+=1;
    }

    @Override
    public Iterator creteIterator() {
        //把数据给迭代器供其操作
        return new ComputerConllegeIterator(departments);
    }
}
//信息工程学院(数据)
class  InfoCollege implements College{
    List<Department> departmentList;

    public InfoCollege() {
        //模拟把学院的系初始化
        this.departmentList = new ArrayList<>();
        addDepartment("信通讯","通讯专业");
        addDepartment("信息安全","信息安全专业");
        addDepartment("服务器安全","服务器安全专业");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departmentList.add(new Department(name,desc));
    }

    @Override
    public Iterator creteIterator() {
        //把数据给迭代器 并返回迭代器
        return new InfoConlleageIterator(departmentList);
    }
}






