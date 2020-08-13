package com.xyl.模式.桥接模式.桥接模式1;

public class TEst {
}
class Client{
    public static void main(String[] args) {
        //折叠式手机样式+品牌
        Phone phone1=new FoldePhone(new XiaoMi());
        phone1.open();
        phone1.close();
        phone1.call();
        System.out.println("----------------");
        phone1=new FoldePhone(new Vivo());
        phone1.open();
        phone1.close();
        phone1.call();
        System.out.println("==================");
        //新增的直板手机+品牌
        phone1=new UpRightPhone(new XiaoMi());
        phone1.open();
        phone1.close();
        phone1.call();
        System.out.println("----------------");
        phone1=new UpRightPhone(new Vivo());
        phone1.open();
        phone1.close();
        phone1.call();
    }
}
//接口 手机品牌
interface Brand{
    //开机
    void open();
    //关机
    void close();
    //打电话
    void call();
}
//品牌实现类
class Vivo implements Brand{
    @Override
    public void open() {
        System.out.println("vivo手机开机了");
    }
    @Override
    public void close() {
        System.out.println("vivo手机关机了");
    }
    @Override
    public void call() {
        System.out.println("vivo手机打电话");
    }
}
//品牌实现类
class XiaoMi implements Brand{
    @Override
    public void open() {
        System.out.println("小米手机开机了");
    }
    @Override
    public void close() {
        System.out.println("小米手机关机了");
    }
    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
//抽象类 手机样式 (桥接类)
abstract class Phone{
    public Phone(Brand brand) {
        this.brand = brand;
    }
    //聚合品牌
    private  Brand brand;
    protected void open(){
        brand.open();
    }
    protected  void close(){
        brand.close();
    }
    protected void call(){
        brand.call();
    }
}
//手机样式 折叠手机
class FoldePhone extends Phone{
    public FoldePhone(Brand brand) {
        super(brand);
    }
    //这里的this.open->Phone.open->Brand.open->Vivo.open
    //他们之间的关联是通过一个Phone的抽象类聚合了一个Brand接口，
    //这里的Phone就是桥接类
    @Override
    protected void open() {
        super.open();
        System.out.println("折叠样式");
    }
    @Override
    protected void close() {
        super.close();
        System.out.println("折叠样式");
    }
    @Override
    protected void call() {
        super.call();
        System.out.println("折叠样式");
    }
}
//新增直板手机
class UpRightPhone extends Phone{
    public UpRightPhone(Brand brand) {
        super(brand);
    }
    @Override
    protected void open() {
        super.open();
        System.out.println("直板样式");
    }
    @Override
    protected void close() {
        super.close();
        System.out.println("直板样式");
    }
    @Override
    protected void call() {
        super.call();
        System.out.println("直板样式");
    }
}


