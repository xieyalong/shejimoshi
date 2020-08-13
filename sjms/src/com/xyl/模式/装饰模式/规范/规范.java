package com.xyl.模式.装饰模式.规范;

public class 规范 {
    //客户端
    public static void main(String[] args) {
//        ADecorator把AAbs给装饰了
        Abs abs=new ADecorator(new AAbs());
    }
}

//被装饰者
abstract  class Abs{
    public int price;
    abstract public int run();
}
//被装饰者子类 可以有很多子类
class AAbs extends Abs{
    //产品的具体价格
    @Override
    public int run() {
        price=10;
        return price;
    }
}
//装饰者
class Decorator extends Abs{
    private Abs abs;
    public Decorator(Abs abs) {
        this.abs = abs;
    }
    //开始具体的包装
    @Override
    public int run() {
        //本身数据外层在加个包装形成一个新的价格
        //在这里层层叠加生成一个新的产品
        return price+abs.price;
    }
}
//具体的装饰者 它可以装饰任何一个被装饰者的子类
class ADecorator extends Decorator{
    public ADecorator(Abs abs) {
        super(abs);
    }
}