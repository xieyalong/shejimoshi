package com.xyl.yuanze_yilaidaozhi.gai;

/**
 * 变量与构造方法参数是接口
 */
public class JieKoue {
    public static void main(String[] args) {
        ChangHong changHong=new ChangHong();
        DaKaiGuanBi daKaiGuanBi=new DaKaiGuanBi(changHong);
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
    private ITV itv;//变量与构造方法参数是接口
    public DaKaiGuanBi(ITV itv) {
        this.itv = itv;
    }

    public void open() {
        itv.play();
    }
}
