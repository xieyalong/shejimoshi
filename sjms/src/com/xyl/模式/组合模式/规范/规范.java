package com.xyl.模式.组合模式.规范;

public class 规范 {
    public static void main(String[] args) {
        //想添加多少等级就添加多少等级
        //第一级
        Composite1 composite1=new Composite1();
        //第二级
        Composite2 composite2_1=new Composite2();
        Composite2 composite2_2=new Composite2();
        //第三级
        Leaf leaf1= new Leaf();
        Leaf leaf2= new Leaf();
        //把第二级添加到第三级里面
        composite2_1.add(leaf2);
        composite2_2.add(new Leaf());
        //把第二级添加到第一级里面
        composite1.add(composite2_1);
        composite1.add(composite2_2);

        //也可以把自己添加成n等级
        composite1=new Composite1();
        composite1.add(new Composite1());
    }
}
//也可以是接口 跟节点  定义规范
abstract class Component{
    public void add(Component c){}
}
//非叶子节点 一级节点
class  Composite1 extends Component{
    @Override
    public void add(Component c) {
        super.add(c);
    }
}

//非叶子节点 二级节点
class  Composite2 extends Component{
    @Override
    public void add(Component c) {
        super.add(c);
    }
}
//叶子节点
class Leaf extends Component{

}