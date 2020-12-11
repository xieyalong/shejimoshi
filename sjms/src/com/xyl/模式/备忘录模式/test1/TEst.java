package com.xyl.模式.备忘录模式.test1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TEst {
    //客户端
    public static void main(String[] args) {
        //创建一个被保存的对象
        Originator originator=new Originator();
        originator.setState("状态1 攻击力100分");
        //备忘录管理者
        Caretaker caretaker=new Caretaker();
        //把备忘录添加到备忘录管理者里面
        caretaker.add(originator.savaMemento());
        //攻击boss后
        originator.setState("状态2 攻击力80分");
        //保存状态2
        caretaker.add(originator.savaMemento());
        //在次攻击boss后 攻击力继续减少
        originator.setState("状态3 攻击力50分");
        //保存状态3
        caretaker.add(originator.savaMemento());

        //====恢复到状态1======
        System.out.println("恢复状态前="+originator.getState());
        originator.getMemento(caretaker.getMemento(0));
        System.out.println("恢复到状态1后="+originator.getState());
    }
}

//被保存的对象
class Originator{
    //状态信息
    public    String state;
    //把当前对象状态保存到备忘录里面
    public  Memento savaMemento(){
        return  new Memento(state);
    }
    //获取备忘录，恢复当前对象的状态
    public  void getMemento(Memento memento){
        state=memento.getState();
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
//备忘录类 保存对象的状态
class Memento{
    private   String state;
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
//备忘录管理者（守护者）
class Caretaker{
    //管理备忘录对象
    //如果多个对象可以使用maplist等
    private List<Memento> mementoList=new ArrayList<>();
    //添加备忘录
    public void add(Memento memento){
        mementoList.add(memento);
    }
    //获取第几个备忘录
    public Memento getMemento(int  index){
        return mementoList.get(index);
    }
}