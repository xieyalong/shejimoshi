package com.xyl.模式.外观模式;

public class 外观模式 {
    public static void main(String[] args) {
        HomeTheaterFacade home=new HomeTheaterFacade();
        home.ready();//准备
        home.play();//播放
    }
}
//外观类 把子系统的打开，关闭，啥的统一关闭
class  HomeTheaterFacade{
    //定义各个子系统的对象
    private TheaterLight theaterLight=TheaterLight.getInstance();//灯光
    private Popcorn popcorn=Popcorn.getInstance();//爆米花机
    private Stereo stereo=Stereo.getInstance();//立体声
    private  Projector projector=Projector.getInstance();//投影仪
    private Screen screen=Screen.getInstance();//屏幕
    private  DVDPlayer dvdPlayer=DVDPlayer.getInstance();
    //操作分成4步走

    //统一打开 准备
    public void ready(){
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.dim();
    }

    public  void play(){
        dvdPlayer.play();//只有dvd有播放
    }
    public  void pause(){
        dvdPlayer.pause();//只有dvd有暂停
    }
    public void  end(){
        popcorn.on();
        theaterLight.bright();
        screen.up();
        projector.off();
        dvdPlayer.off();
        popcorn.off();
        stereo.off();
    }
}
//dvd
class DVDPlayer{
    private static DVDPlayer instance=new DVDPlayer();
    public static DVDPlayer getInstance(){
        return instance;
    }
    public void on(){
        System.out.println("dvd打开");
    }
    public void off(){
        System.out.println("dvd关闭");
    }
    public  void play(){
        System.out.println("dvd播放");
    }
    public void pause(){
        System.out.println("dvd暂停");
    }
}
//爆米花机
class Popcorn{
    private static Popcorn instance=new Popcorn();
    public static Popcorn getInstance(){
        return instance;
    }
    public void on(){
        System.out.println("爆米花机打开");
    }
    public void off(){
        System.out.println("爆米花机关闭");
    }
    public  void pop(){
        System.out.println("出爆米花");
    }
}
//投影仪
class Projector{
    private static Projector instance=new Projector();
    public static Projector getInstance(){
        return instance;
    }
    public void on(){
        System.out.println("投影仪打开");
    }
    public void off(){
        System.out.println("投影仪关闭");
    }
    public  void focus(){
        System.out.println("投影仪聚焦");
    }
}

//屏幕
class Screen{
    private static Screen instance=new Screen();
    public static Screen getInstance(){
        return instance;
    }
    public void up(){
        System.out.println("屏幕网上升");
    }
    public void down(){
        System.out.println("屏幕网下降");
    }
}
//立体声
class Stereo{
    private static Stereo instance=new Stereo();
    public static Stereo getInstance(){
        return instance;
    }
    public void on(){
        System.out.println("立体声打开");
    }
    public void off(){
        System.out.println("立体声关闭");
    }
    public  void up(){
        System.out.println("立体声音量调大");
    }
}
//灯光
class TheaterLight{
    private static TheaterLight instance=new TheaterLight();
    public static TheaterLight getInstance(){
        return instance;
    }
    public void on(){
        System.out.println("灯光打开");
    }
    public void off(){
        System.out.println("灯光关闭");
    }
    public  void dim(){
        System.out.println("灯光调亮");
    }
    public  void bright(){
        System.out.println("灯光调暗");
    }
}