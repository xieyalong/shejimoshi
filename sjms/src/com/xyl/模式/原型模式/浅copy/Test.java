package 原型模式;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static sun.misc.Version.println;

public class Test {
}
class  Client{
    public static void main(String[] args) {
        Sheep sheep=new Sheep("tom");
        sheep.sheep=new Sheep("新疆羊");
        Sheep sheep1=(Sheep)sheep.clone();
        System.out.println("=====引用类型的深copy=======");
        //sheep=1627674070
        System.out.println("sheep="+sheep.hashCode());
//        sheep1=1360875712
        System.out.println("sheep1="+sheep1.hashCode());
        System.out.println("=====引用类型的浅copy=======");
//        sheep.sheep=1625635731
        System.out.println("sheep.sheep="+sheep.sheep.hashCode());
//        sheep1.sheep=1625635731
        System.out.println("sheep1.sheep="+sheep1.sheep.hashCode());
        System.out.println("=====基本类型的clone=======");
        sheep1.setName("tom2");
        //sheep.name=tom
        System.out.println("sheep.name="+sheep.getName());
//        sheep.name=tom2
        System.out.println("sheep1.name="+sheep1.getName());
    }
}

//羊
class  Sheep implements Cloneable{
    private  String name;
    public  Sheep sheep;
    public Sheep(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //重写克隆 实现原型模式
    @Override
    protected Object clone(){
        Sheep sheep=null;
        try {
            sheep=(Sheep) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sheep;
    }
}