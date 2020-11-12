package com.xyl.模式.模版模式.基本模版模式;

public class 豆浆制作 {
    public static void main(String[] args) {
        //红糖豆浆
        SoyaMilk soyaMilk=new RedBeanSoyaMilk();
        soyaMilk.make();

        //花生豆浆
        soyaMilk=new PeantSoyaMilk();
        soyaMilk.make();
    }
}


//抽象类，定义模版方法和制定流程(豆浆)
abstract class  SoyaMilk{
    //模版方法（定义流程） 模版方法可以做成final 不让子类覆盖
    final public  void make(){
        select();
        addCondiments();
        soak();
        beat();
    }
    //选材料
    void select(){
        System.out.println("第一步：选择好的新鲜豆子");
    }
    //添加不同的配料，由子类实现
    abstract void  addCondiments();
    //浸泡
    void soak(){
        System.out.println("第三步：黄豆和配料开始浸泡");
    }
    //打碎
    void beat(){
        System.out.println("第四步：黄豆和配料放到豆浆机打碎");
    }
}
//红糖配料的豆浆，细化红糖豆浆
class RedBeanSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        System.out.println("红糖配料");
    }
}
//花生配料豆浆 细化花生豆浆
class PeantSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        System.out.println("花生配料");
    }
}

