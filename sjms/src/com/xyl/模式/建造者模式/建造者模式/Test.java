package com.xyl.模式.建造者模式.建造者模式;

//客户端
public class Test {

    public static void main(String[] args) {
        //普通的房子
        FangZi fangZi=  new FangZi();
        //指挥者 具体是建普通的房子还是高楼由指挥者来选择
        HouseDirector director=new HouseDirector(fangZi);
        //得到产品对象(房子建造完成)
        House house=director.constructHouse();
        //可以单独的查看自己的墙的厚度
        System.out.println(house.qiang);
        System.out.println("======在创建一个高楼=======");
        //高楼
        GaoLou gaolou=  new GaoLou();
        director.setBuilder(gaolou);
        //房子建造完成
        house=director.constructHouse();
        System.out.println(house.qiang);
    }
}

//产品 房子有 地基，墙，屋顶组成
class House{
    //地基
    public String diJi;
    //墙
    public  String qiang;
    //屋顶
    public String wuDing;
}

//抽象的建造者 builder 制定流程
abstract  class HouseBuilder{
    protected House house=new House();
    //地基
    public abstract  void buildDiJi();
    //砌墙
    public abstract void buildQiQiang();
    //封顶
    public  abstract void buildFengDing();
    //建造房子
    public House buildHouse(){
        return house;
    }
}

//具体的建造者conreteBuilder 普通房子
class  FangZi extends HouseBuilder{

    @Override
    public void buildDiJi() {
        buildHouse().diJi="50米";
        System.out.println("普通房子打地基 50米");
    }

    @Override
    public void buildQiQiang() {
        buildHouse().qiang="10cm";
        System.out.println("普通房子砌墙 10cm");
    }

    @Override
    public void buildFengDing() {
        buildHouse().wuDing="砖瓦的";
        System.out.println("普通房子盖屋顶 砖瓦的");
    }
}

//具体的建造者conreteBuilder 高楼
class  GaoLou extends HouseBuilder{

    @Override
    public void buildDiJi() {
        buildHouse().diJi="100米";
        System.out.println("高楼打地基 100米");
    }

    @Override
    public void buildQiQiang() {
        buildHouse().qiang="20cm";
        System.out.println("高楼砌墙 20cm");
    }

    @Override
    public void buildFengDing() {
        buildHouse().wuDing="玻璃的";
        System.out.println("高楼盖屋顶 玻璃的");
    }
}

//指挥者  指定具体要建造什么样的产品，返回一个真实的对象
//如是建普通房子，还是高楼，都由它来决定
class HouseDirector{
    private HouseBuilder builder;
    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }
    public void setBuilder(HouseBuilder builder) {
        this.builder = builder;
    }
    public  House constructHouse(){
        builder.buildDiJi();
        builder.buildQiQiang();
        builder.buildFengDing();
        return builder.buildHouse();
    }
}