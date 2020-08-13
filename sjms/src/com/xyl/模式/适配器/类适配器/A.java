package com.xyl.模式.适配器.类适配器;



//被适配类（src类，最初的数据源）
class BeiShiPei{
    //数据源
    String data;
}
//目标类（dst类，定义使用类的规范）
interface  MuBiao{
    //定义目标转换数据的方法，让adapter去实现
    String zhuanHuan();
}
//适配器 继承被适配类 实现目标类并供使用类使用
class Adapter extends BeiShiPei implements MuBiao{
    //处理数据 转成使用类所用的数据
    @Override
    public  String zhuanHuan(){
        //处理数据源 把转换后的数据给使用类
        String str=data;
        return  str;
    }
}
//使用类
class ShiYong{
    //通过适配器 得到转换后的数据
    public  void run(MuBiao muBiao){
        //处理数据源 把转换后的数据给使用类
        String data=muBiao.zhuanHuan();
    }
}
//客户端
public class A {
    public static void main(String[] args) {
        //new 使用类
        ShiYong sy=new ShiYong();
        //把适配器给使用类
        //好处在于 当使用类在用到别的数据结构时候可以在写个适配器
        sy.run(new Adapter());
    }
}