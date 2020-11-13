package com.xyl.模式.命令模式.Test1;

import java.util.Queue;

public class A {
    public static void main(String[] args) {
        //通过遥控器对点灯的操作

        //执行者
        LightReceiver lightReceiver=new LightReceiver();
        //开灯命令
        LightOncommand lightOncommand=new LightOncommand(lightReceiver);
        //关灯命令
        LightOffcommand lightOffcommand=new LightOffcommand(lightReceiver);
        //遥控器
        RemoteController controller=new RemoteController();
        //no=0 灯的开和关
        //no=1 电视的开和关
        int index=0;
        //指挥者绑定命令
        controller.setCommand(index,lightOncommand,lightOffcommand);
        //按下灯的开按钮
        controller.onButtonWasPUshed(index);
        //按下灯的撤销按钮
        controller.undoButtonWasPUshed();
        //按下灯的关按钮
        controller.offButtonWasPUshed(index);
        //按下灯的撤销按钮
        controller.undoButtonWasPUshed();
    }
}

//命令类
interface Command{
    //执行操作
    void execute();
    //撤销命令
    void undo();
}

//执行者
class LightReceiver{
    public void on(){
        System.out.println("开灯");
    }
    public void off(){
        System.out.println("关灯");
    }
}

//开灯命令，命令执行者开灯
class  LightOncommand implements Command{
    //执行者
    LightReceiver lightReceiver;

    public LightOncommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //命令调用执行者的方法 开灯
        lightReceiver.on();
    }

    @Override
    public void undo() {
        System.out.println("撤销打开");
        //撤销开灯
        lightReceiver.off();
    }
}
//关灯命令，命令执行者关灯
class  LightOffcommand implements Command{
    //执行者
    LightReceiver lightReceiver;

    public LightOffcommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //命令调用执行者的方法 关灯
        lightReceiver.off();

    }

    @Override
    public void undo() {
        //撤销关灯
        System.out.println("撤销关闭");
        lightReceiver.on();
    }
}

//空命令，简化操作，有帮助可以省去对null的判断（
// 也就是说对象存在，但是对象里面的值都是null）
//没有任何命令，用于初始化每个按钮，当调用空命令时对象什么也不用
//这也是一种设计模式，可以省去对空判断
class NoCommand  implements  Command{
    @Override public void execute() {}
    @Override public void undo() {}
}
//遥控器 指挥者
class RemoteController{
    int size=5;//5个设备 都有开和关
    //开
    Command[] onCommands;
    //关
    Command[] offCommands;
    //执行撤销命令 记录本次操作的对象
    Command undoCommand;

    //实例化对象
    public RemoteController() {
        onCommands=new Command[size];
        offCommands=new Command[size];
        for (int i = 0; i <size ; i++) {
            onCommands[i]=new NoCommand();
            offCommands[i]=new NoCommand();
        }
    }
    //设置按钮的命令
    public  void setCommand(int  no,Command onCommand,Command offCommand){
        onCommands[no]=onCommand;
        offCommands[no]=offCommand;
    }
    //开按钮
    public void  onButtonWasPUshed(int no){
        //找到按下开的按钮，并调用对应的方法，如果
        onCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand=onCommands[no];
    }
    //关按钮
    public void  offButtonWasPUshed(int no){
        //找到按下开的按钮，并调用对应的方法，如果
        offCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand=offCommands[no];
    }
    //撤销按钮
    public  void undoButtonWasPUshed(){
        undoCommand.undo();
    }
}