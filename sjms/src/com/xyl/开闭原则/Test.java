package com.xyl.开闭原则;
//改进后
public class Test {
    public static void main(String[] args) {
        Hua hua=new Hua();
        hua.huaTu(new YuanXing());
        hua.huaTu(new JuXing());
        //只需要扩展一个类就可以增加使用方的功能
        //不需要大改
        hua.huaTu(new SanJiaoXing());
    }
}
//使用方
class  Hua{
    public  void huaTu(HuiZhi hz){
        hz.huiZhiTu();
    }
}

//提供方的基类
//把绘制方法改成抽象方法,让子类来实现此方法
abstract class  HuiZhi{
    //绘制图形
    public  abstract  void huiZhiTu();
}

class YuanXing extends HuiZhi{
    @Override
    public void huiZhiTu() {
        System.out.println("画圆");
    }
}
class JuXing extends  HuiZhi{
    @Override
    public void huiZhiTu() {
        System.out.println("画矩形");
    }
}
//只需要新增这个一个类就行，其他的不用修改
class SanJiaoXing extends HuiZhi{
    @Override
    public void huiZhiTu() {
        System.out.println("画三角形");
    }
}



////改进前
//public class Test {
//    public static void main(String[] args) {
//       Hua hua=new Hua();
//       hua.huaTu(new YuanXing());
//       hua.huaTu(new JuXing());
//       hua.huaTu(new SanJiaoXing());//新增三角形
//    }
//}
////使用方法
//class  Hua{
// public  void huaTu(HuiZhi hz){
//        if (hz.type==1){
//            huaYuan(hz);
//        }else if (hz.type==2){
//            huaJuXing(hz);
//        }else if (hz.type==3){//新增三角形
//           sanjiaoxing(hz);
//        }
//    }
//    private    void huaYuan(HuiZhi hz){
//        System.out.println("画圆");
//    }
//    private   void huaJuXing(HuiZhi hz){
//        System.out.println("画矩形");
//    }
//    //新增的三角形
//    private void sanjiaoxing(HuiZhi hz){
//        System.out.println("画三角形");
//    }
//}
////提供方的基类
//class  HuiZhi{
//    int type=0;
//}
//class YuanXing extends HuiZhi{
//    public YuanXing() {
//        this.type=1;
//    }
//}
//class JuXing extends  HuiZhi{
//    public JuXing() {
//        this.type=2;
//    }
//}
////新增三角形
//class SanJiaoXing extends HuiZhi{
//    public SanJiaoXing() {
//        this.type=3;
//    }
//}