package com.xyl.模式.观察者模式.test;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //创建一个变动因子（主题）
        WeatheData subject=new WeatheData();
        //把新浪观察者注册到变动因子里面
        subject.register(new SinaObserver());
        //把百度观察者注册到变动因子里面
        subject.register(new BaiduObserver());
        //变动因子改变了 新浪和百度就会及时更新数据
        subject.setData(4);
    }
}


//主题（变动因子，老师）
interface  Subject{
    //注册观察者
    void register(Observer observer);
    //删除观察者
    void  remove(Observer observer);
    //通知观察者
    void  notifyObservers();
}
//观察者（放风人，观察老师是否来了）
interface  Observer{
    //temperatrue 温度
    void update(float temperatrue);
}


//气象站 （主题，变动因子）具体类
// 管理观察者 注册，通知，删除
//当数据改变时通知所有观察者更新信息
class WeatheData implements Subject{
    //观察者集合
    List<Observer> observers= new ArrayList<>();
    float temperatrue;
    //数据设置
    public void  setData(float temperatrue) {
        this.temperatrue = temperatrue;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    //通知所有的观察者
    @Override
    public void notifyObservers() {
        for (int i = 0; i <observers.size() ; i++) {
            observers.get(i).update(temperatrue);
        }
    }
}


//新浪接收气象信息 观察者
class SinaObserver implements  Observer{
    @Override
    public void update(float temperatrue) {
        System.out.println("新浪接到通知：气压为="+hashCode());
    }
}

//百度接收气象信息 观察者
class  BaiduObserver implements Observer{
    @Override
    public void update(float temperatrue) {
        System.out.println("百度接到通知：气压为="+hashCode());
    }
}


