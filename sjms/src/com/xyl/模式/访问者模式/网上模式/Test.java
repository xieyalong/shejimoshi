package com.xyl.模式.访问者模式.网上模式;



import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //数据结构的组装者
        ObjectStructure os=new ObjectStructure();
        System.out.println("--------把元素添加到数据结构中-----------");
        //工程师(元素)加入数据结构中
        //这里具有扩展性
        //如果有个老板娘查看谁发的工资多
        // 可以直接添加个老板娘的访问类和工资的元素
        os.attache(new Engineer("工程师-张三"));
        //产品经理(元素)加入数据结构中
        os.attache(new Manager("产品经理-李四"));
        System.out.println("----ceo（访问者）访问工程师的kpi 产品经理的产品数量-----------");
        os.display(new CEOVisitor());
        System.out.println("----cto（访问者）访问工程师的代码质量 产品经理的产品数量-----------");
        os.display(new CTOVisitor());
    }
}

//访问者 ceo和cto
interface Visitor{
    //访问工程师
    //缺点：
    //1,违反了迪米特原则（最少知道原则）： 访问者直接访问了具体的实现类
    //2,违反了依赖倒转原则（抽象不应该依赖具体类）：这里抽象类依赖了具体类
    //3,元素实现类变更时导致访问者的实现类也跟着改变（知道最小原则）
    void visitEngineer(Engineer element);
    //访问产品经理
    void visitManager (Manager element);
}
//ceo访问者
class CEOVisitor implements Visitor{

    //访问的是具体的元素类
    @Override
    public void visitEngineer(Engineer element) {
        int i=new Random().nextInt(10);
        System.out.println("工程师："+element.name+"---pki="+i);
    }

    @Override
    public void visitManager(Manager element) {
        int i=new Random().nextInt(10);
        System.out.println("产品经理："+element.name+"---pki="+i+"---产品数量="+element.sum);
    }
}
//ceo访问者
class CTOVisitor implements Visitor{

    @Override
    public void visitEngineer(Engineer element) {
        System.out.println("工程师："+element.name+"---代码质量="+element.daimazhiliang);
    }

    @Override
    public void visitManager(Manager element) {
        System.out.println("产品经理："+element.name+"---产品数量="+element.sum);
    }
}


//访问元素
abstract  class Element {
    public String name;

    public Element(String name) {
        this.name = name;
    }
    // 核心方法 标准的方法名，接受Visitor的访问
    abstract void  accept(Visitor visitor);
}
//工程师元素
class  Engineer extends Element{

    //kpi
    public int kpi=new Random().nextInt(10);
    //产品数量
    public int sum=new Random().nextInt(10);
    //代码质量
    public int daimazhiliang=new Random().nextInt(10);
    public Engineer(String name) {
        super(name);
    }

    @Override
    void accept(Visitor visitor) {
        //this：是某个visitor访问了自己
        visitor.visitEngineer(this);
    }
}

//产品经理元素
class  Manager  extends Element{
    //kpi
    public int kpi=new Random().nextInt(10);
    //产品数量
    public int sum=new Random().nextInt(10);
    public Manager (String name) {
        super(name);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitManager(this);
    }
}

class ObjectStructure{//aaagggg
    //可能是类，可能是集合
    private List<Element> persons=new LinkedList<>();
    //增加到集合中
    public void attache(Element visitor){
        persons.add(visitor);
    }
    //删除
    public void detach(Element visitor){
        persons.remove(visitor);
    }
    //访问者访问元素
    public void display(Visitor visitor){
        for (Element p:persons){
            p.accept(visitor);
        }
    }
}


