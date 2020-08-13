package com.xyl.模式.装饰模式.装饰者模式1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;

class T{
    public static void main(String[] args) throws FileNotFoundException {
        DataInputStream dis=new DataInputStream(new FileInputStream(""));
    }
}
public class Test {
    public static void main(String[] args) {
        //订单：2份巧克力+一份牛奶+美式咖啡（longBlack）
        //1，先点一份美式咖啡
        Drink drink=new LongBlackCoffee();
        System.out.println("美式咖啡￥="+drink.cost());
        System.out.println("-----------------");
        //2,加入一份牛奶 牛奶装饰了美式咖啡
        drink=new Milk(drink);
        System.out.println("美式咖啡+牛奶￥="+drink.cost());
        System.out.println("-----------------");
        //3,加入一份巧克力 巧克力装饰了牛奶+美式咖啡
        drink=new Choclate(drink);
        System.out.println("美式咖啡+牛奶+巧克力￥="+drink.cost());
        System.out.println("-----------------");
        //4,在加入一份巧克力 巧克力装饰了巧克力+牛奶+美式咖啡
        drink=new Choclate(drink);
        System.out.println("美式咖啡+牛奶+巧克力+巧克力￥="+drink.cost());
        System.out.println("-----------------");
        //在购买一个意大利开发
        drink=new EspressoCoffee();
        System.out.println("意大利咖啡￥="+drink.cost());
    }
}

//饮料（被装饰者）
abstract  class Drink{
    public String des;//描述
    public int  price;//价格
    //计算费用 不通的饮料价格不同
    abstract public int cost();
}
//咖啡类 缓冲层 因为cons 不写的话就再 每个子类中实现
//如LongBlackCoffee，EspressoCoffee都要去实现它
class  Coffee extends Drink{
    @Override
    public int cost() {
        return super.price;
    }
}
//美式咖啡
class  LongBlackCoffee extends  Coffee{
    public LongBlackCoffee() {
        des="美式咖啡";
        price=20;
        System.out.println("单点"+des+"￥="+price);
    }
}
//新增意大利咖啡
class  EspressoCoffee extends  Coffee{
    public EspressoCoffee() {
        des="意大利咖啡";
        price=10;
        System.out.println(des+"费用="+price);
    }
}


////黑色咖啡
//class  ShortBlackCoffee extends  Coffee{
//    public ShortBlackCoffee() {
//        des="黑色咖啡";
//        price=5;
//        System.out.println(des+"费用="+price);
//    }
//}

//装饰者
class Decorator extends Drink{
    //被装饰者
    private Drink obj;
    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public int cost() {
        //price=自己的价格
        //obj.price=装饰者的价格
        return price+obj.cost();
    }
}
//具体的调味品 这里就是调味品
class Choclate extends Decorator{

    public Choclate(Drink obj) {
        super(obj);
        des="巧克力";
        price=3;//调味品的价格

        System.out.println("单点"+des+"￥="+price);
    }
}
//牛奶味调味品
class Milk extends Decorator{

    public Milk(Drink obj) {
        super(obj);
        des="牛奶";
        price=2;//调味品的价格
        System.out.println("单点"+des+"￥="+price);
    }
}

//豆浆味调味品
class Soy extends Decorator{

    public Soy(Drink obj) {
        super(obj);
        des="豆浆";
        price=1;//调味品的价格
        System.out.println("单点"+des+"￥="+price);
    }
}



