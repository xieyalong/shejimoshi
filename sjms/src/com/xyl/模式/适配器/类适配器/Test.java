package com.xyl.模式.适配器.类适配器;





public class Test {
    //客户端
    public static void main(String[] args) {
        Phone phone=new Phone();
        phone.charging(new VoltageAdapter());
    }
}

//被适配的类
class Voltage220v{
    public  int output220(){
        int  src=220;
        System.out.println("电压="+src+"伏");
        return  src;
    }
}
//目标类(适配接口 ) 要适配者成5v的电压
interface IVoltage5v{
    int output5v();
}
//适配器 继承被适配者 还要实现目标
class VoltageAdapter extends Voltage220v implements IVoltage5v{

    @Override
    public int output5v() {
        int src=output220();
        //转成手机的电压
        int dstV=src-215;
        //把处理后的电压返回
        return dstV;
    }
}
//手机充电要用5v的电压
class Phone{
    //充电
    void charging(IVoltage5v iVoltage5v){
        if (iVoltage5v.output5v()==5){
            System.out.println("电压5伏可以充电");
        }else{
            System.out.println("电压过高，无法充电");
        }
    }
}
