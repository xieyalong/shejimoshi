package com.xyl.yuanze_yilaidaozhi.gai2;

/**
 * 成员变量是接口
 */
public class JieKoue {
    public static void main(String[] args) {
        ChangHong changHong=new ChangHong();
        DaKaiGuanBi daKaiGuanBi=new DaKaiGuanBi();
        daKaiGuanBi.setItv(changHong);
        daKaiGuanBi.open();
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
class DaKaiGuanBi{
    ITV itv;//变量,通过set方式传递接口的实现
    public void setItv(ITV itv) {
        this.itv = itv;
    }

    public void open() {
        itv.play();
    }
}
