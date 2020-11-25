//package com.xyl.模式.中介者模式;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class 案例代码 {
//}
////中介类
//abstract class Mediator{
//    //把同事类加入到中介类集合中
//    abstract  void register(String conlleagueName,Conlleague conlleague);
//    //接收同事类发出的消息
//    abstract void getMessage(int  stateChange,String conlleagueName);
//    //1，根据得到的消息完成相应的任务
//    //2，中介者在这个方法中，协调各个具体的同事对象，完成任务
//    abstract  void sendMessage();
//}
//
////具体的中介者类
//class ConcreMediator extends Mediator{
//    //存放同事对象
//    private Map<String,Conlleague> conlleagueMap=new HashMap<>();
//    private Map<String,String> interMap=new HashMap<>();
//
//    @Override
//    void register(String conlleagueName, Conlleague conlleague) {
//        conlleagueMap.put(conlleagueName,conlleague);
//        if (conlleague instanceof Alarm){
//            interMap.put("Alarm",conlleagueName);
//        }else   if (conlleague instanceof ConffeeMachine){
//            interMap.put("ConffeeMachine",conlleagueName);
//        }else   if (conlleague instanceof TV){
//            interMap.put("TV",conlleagueName);
//        }else   if (conlleague instanceof Curtains){
//            interMap.put("Curtains",conlleagueName);
//        }
//
//    }
//
//    @Override
//    void getMessage(int stateChange, String conlleagueName) {
//        if (0==stateChange){
//            conlleagueMap.get(interMap.get(conlleagueName)).start
//        }
//    }
//
//    @Override
//    void sendMessage() {
//
//    }
//}
////同事类
//abstract class  Conlleague{
//    private  Mediator mediator;
//    public    String name;
//
//    public Conlleague(Mediator mediator, String name) {
//        this.mediator = mediator;
//        this.name = name;
//    }
//
//    public Mediator getMediator() {
//        return mediator;
//    }
//    abstract void sendMessage(int  stateChange);
//}
//
////具体的同事类
//class Alarm extends  Conlleague{
//
//    public Alarm(Mediator mediator, String name) {
//        super(mediator, name);
//        mediator.register(name,this);
//    }
//    public  void sendAlarm(int stateChange){
//        sendMessage(stateChange);
//    }
//    @Override
//    void sendMessage(int stateChange) {
//        //调用中介者
//        getMediator().getMessage(stateChange,this.name);
//    }
//}
//
//class ConffeeMachine extends  Conlleague{}
//class Curtains extends  Conlleague{}
//class TV extends  Conlleague{}