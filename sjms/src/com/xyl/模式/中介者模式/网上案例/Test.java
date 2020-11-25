package com.xyl.模式.中介者模式.网上案例;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Mediator mediator=new HouseMediator();
        //往中介者里面注册房子
        mediator.addHouse("单间",new SmallHouseColleague());
        mediator.addHouse("两居室",new TwoHouseConlleague());
        mediator.addHouse("三居室",new ThreeHouseConlleague());
        //租户要看单间
        mediator.common("单间");
        //租户要看两居室
        mediator.common("两居室");
        //租户要看三居室
        mediator.common("三居室");
    }
}

//中介抽象类 定义各个同事类之间的交互方法
//让客户端只和我关联，让客户端一对多转成了一对一的关系
//简化了客户端的复杂操作
abstract class Mediator{
    //添加同事类
    public abstract void  addHouse(String house_name,Colleague colleague);
    //和同事类之间交互通信
    public abstract  void common(String house_name);
}
//同事类，定义基本的一些方法
abstract  class  Colleague{
    //处理自己的事物（房东展示自己的房屋）
    public  abstract void handle();
    abstract void getMsg(String content);
}

//具体的房屋中介
class HouseMediator extends Mediator{
    //存储所有同事类（所有房子）
    Map<String,Colleague> map=new HashMap<>();
    private  boolean isZu=false;
    public void  addHouse(String house_name,Colleague colleague){
        map.put(house_name,colleague);
    }

    @Override
    public void common(String house_name) {
        if ("单间".equals(house_name)){
            SmallHouseColleague smal=(SmallHouseColleague) map.get(house_name);
            smal.handle();
            //这里代表还可以添加其他的信息在这里进行操作
            smal.restsHouse();
        }else if ("两居室".equals(house_name)){
            TwoHouseConlleague two=(TwoHouseConlleague)map.get(house_name);
            two.handle();
            //判断是否租出去了，
            // 租出去了 要通知其他房东 你们不用给我继续介绍了 我这边的房子已经租出去了
            if (two.getIsZu()){
                sendMsg(house_name);
            }
        }else if ("三居室".equals(house_name)){
            map.get(house_name).handle();
        }
    }

    public void sendMsg(String houseName) {
        System.out.println("======中介通知其他房东 开始=============");
        //这里的通知其他房东，和观察者模式一样
        for (String key : map.keySet()){
            if (!houseName.equals(key)){
                String str=key+"房东你好，我是中介，"+houseName+"的房子已经租出去了，你们不用在给他介绍了";
                map.get(key).getMsg(str);
            }
        }
        System.out.println("======中介通知其他房东 结束=============");
    }
}
//同事类 房东
class SmallHouseColleague extends Colleague{
    @Override
    public void handle() {
        System.out.println("单间房东");
    }
    //可以添加具体方法的其他的数据
    public  void restsHouse(){
        System.out.println("单间没有相中，我这还有其他房间你还可以看看");
    }
    @Override
    void getMsg(String content) {
        System.out.println("small房东收到消息="+content);
    }


}
//同事类 房东
class  TwoHouseConlleague extends  Colleague{
    @Override
    public void handle() {
        System.out.println("两居室房东 我的房屋已经出租");
    }
    //是否已经租出去了
    public boolean getIsZu(){
        return true;
    }
    @Override
    void getMsg(String content) {
        System.out.println("Two房东收到消息="+content);
    }
}
//同事类 房东
class  ThreeHouseConlleague extends  Colleague{
    @Override
    public void handle() {
        System.out.println("三居室房东");
    }
    @Override
    void getMsg(String content) {
        System.out.println("Three房东收到消息="+content);
    }
}