package com.xyl.模式.命令模式.规范;

public class 规范 {
    public static void main(String[] args) {
        //执行者
        Receiver receiver=new Receiver();
        //开启命令
        OnCommand onCommand=new OnCommand(receiver);
        //关闭命令
        OffCommand offCommand=new OffCommand(receiver);
        //发布者（指挥者）
        Controller controller=new Controller();
        //给指挥者设置命令
        controller.setOnCommand(onCommand,offCommand);
        //开启
        controller.on();
        System.out.println("点击了取消");
        //取消开启
        controller.undo();
        //关闭
        controller.off();
        System.out.println("点击了取消");
        //取消关闭
        controller.undo();
    }
}


//执行类 里面的方法只是个例子
class Receiver{
    public  void on(){
        System.out.println("开启");
    }
    public  void off(){System.out.println("关闭");}
}

//命令类
// 里面的方法只是例子
//但必须有撤销命令，没有撤销命令不是严格意义上的命令模式
interface Command{
    //执行操作
    void execute();
    //撤销命令
    void undo();
}
//命令的实现类，命令实现最小化 如开和关是两个命令
class OnCommand implements Command{
    //命令类聚合执行类
    Receiver receiver;

    public OnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.on();
    }

    @Override
    public void undo() {
    receiver.off();
    }
}
//命令的实现类，命令实现最小化 如开和关是两个命令
class OffCommand implements Command{
    //命令类聚合执行类
    Receiver receiver;

    public OffCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.off();
    }

    @Override
    public void undo() {
        receiver.on();
    }
}
//指挥类，这里一定实现命令最小化
class Controller{
    //指挥类聚合命令类
    private Command onCommand;//开启命令
    private Command offCommand;//关闭命令
    private Command undoCommand;//取消命令
    //设置命令
    public void setOnCommand(Command onCommand,Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }
    //发布开启命令
    public  void on(){
        onCommand.execute();
        undoCommand=onCommand;
    }
    //发布关闭命令
    public  void off(){
        offCommand.execute();
        undoCommand=offCommand;
    }
    //取消命令
    public  void undo(){
        undoCommand.undo();
    }
}


