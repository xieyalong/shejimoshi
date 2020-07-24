package com.xyl.yuanze_yilaidaozhi;

/**
 * 通过接口方法传递接口进行依赖
 */
public class JDJieKou1 {
    public static void main(String[] args) {
        //长虹实现了播放器
        ChangHong changHong=new ChangHong();
        //长虹电视机的打开和关闭功能
        DaKaiGuanBi openAndClose=new DaKaiGuanBi();
        openAndClose.open(changHong);
    }
}

//打开 关闭
interface  IOpenAndClose{
    void open(ITV itv);
}
//播放器
interface  ITV{
    void play();
}
//长虹电视机
class ChangHong implements ITV {
    @Override
    public void play() {
        System.out.println("长虹电视机播放");
    }
}
//打开关闭实现类
class DaKaiGuanBi implements IOpenAndClose {
    public void open(ITV itv) {
        itv.play();
    }
}
