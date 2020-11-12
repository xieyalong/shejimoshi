package com.xyl.模式.命令模式.Test1;

import java.util.Queue;

public class A {
    public static void main(String[] args) {
        //通过遥控器对点灯的操作

        //执行者
        LightReceiver lightReceiver=new LightReceiver();
        //打开点灯命令
        LightOncommand lightOncommand=new LightOncommand(lightReceiver);
        //关闭点灯命令
        LightOffcommand lightOffcommand=new LightOffcommand(lightReceiver);
        //遥控器
        RemoteController controller=new RemoteController();
        //no=0 点灯的开和关
        //no=1 电视的开和关
        int index=0;
        controller.setCommand(index,lightOncommand,lightOffcommand);
        //按下灯的开按钮
        controller.onButtonWasPUshed(index);
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
//遥控器
class RemoteController{
    int size=5;//5个设备 都有开和关
    //开按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;
    //执行操作命令
    Command undoCommand;

    public RemoteController() {
        onCommands=new Command[size];
        offCommands=new Command[size];
        for (int i = 0; i <size ; i++) {
            onCommands[i]=new NoCommand();
            offCommands[i]=new NoCommand();
        }
    }
    //给我们的按钮设置你需要设置的命令
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
    //管按钮
    public void  offButtonWasPUshed(int no){
        //找到按下开的按钮，并调用对应的方法，如果
        offCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand=offCommands[no];
    }
    //撤销那妞
    public  void undoButtonWasPUshed(){
        undoCommand.undo();
    }
}
//执行者
class LightReceiver{
    public void on(){
        System.out.println("点灯打开了");
    }
    public void off(){
        System.out.println("点灯关闭了");
    }
}

//打开点灯命令
class  LightOncommand implements Command{
    LightReceiver lightReceiver;

    public LightOncommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //调用执行者的方法 如打开
        lightReceiver.on();
    }

    @Override
    public void undo() {
        lightReceiver.off();
    }
}
//关闭电灯命令
class  LightOffcommand implements Command{
    LightReceiver lightReceiver;

    public LightOffcommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //调用执行者的方法 如打开
        lightReceiver.off();

    }

    @Override
    public void undo() {
        lightReceiver.on();
    }
}

//空命令，简化操作，有帮助可以省去对null的判断
//没有任何命令，用于初始化每个按钮，当调用空命令时对象什么也不用
//这也是一种设计模式，可以省去对空判断
class NoCommand  implements  Command{

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}