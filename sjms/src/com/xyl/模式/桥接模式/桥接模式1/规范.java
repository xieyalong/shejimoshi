package com.xyl.模式.桥接模式.桥接模式1;





class Client1{
    public static void main(String[] args) {
        //如果增新的功能只需要新增abs的子类或者itfc的实现类即可
        Abs abs=new AEtds(new AImpl());
        abs.run();

        abs=new AEtds(new BImpl());
        abs.run();

        abs=new BEtds(new BImpl());
        abs.run();
    }
}
//接口（完成半个或独立完成某一项任务）
interface Itfc{
    void run();
}
//接口实现类a
class AImpl implements Itfc{
    @Override
    public void run() {}
}
//接口实现类b
class BImpl implements Itfc{
    @Override
    public void run() {}
}
//抽象类（桥接类） 具体功能（itfc）的一个辅助类
//完成和接口实现类的桥接功能
abstract  class  Abs{
    private Itfc itfc;
    public Abs(Itfc itfc) {
        this.itfc = itfc;
    }
    protected void run(){
        itfc.run();
    }
}
//抽象类的实现类a
class AEtds extends Abs{
    public AEtds(Itfc itfc) {
        super(itfc);
    }
    //AEtds.run->Abs.run->Itfc.run-AImpl.run
    //Abs做了桥接
    @Override
    protected void run() {
        super.run();
    }
}
//抽象类的实现类b
class BEtds extends Abs{
    public BEtds(Itfc itfc) {
        super(itfc);
    }
    @Override
    protected void run() {
        super.run();
    }
}
