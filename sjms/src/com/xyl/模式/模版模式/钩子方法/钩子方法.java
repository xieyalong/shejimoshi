package com.xyl.模式.模版模式.钩子方法;

public class 钩子方法 {
    public static void main(String[] args) {
        SoyaMilk soyaMilk=new PureSoyaMIlk();
        soyaMilk.make();
    }
}

//抽象类，定义模版方法和制定流程(豆浆)
abstract class  SoyaMilk{
    //模版方法（定义流程） 模版方法可以做成final 不让子类覆盖
    final public  void make(){
        select();
        //这里的isAdd()就是钩子，控制那个流程段可以运行
        if (isAdd()){
            addCondiments();
        }
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
    //这里就是钩子方法，用来控制addCondiments（）是否进入大的流程中，
    // 即使子类实现了用来控制addCondiments()运行的时候也不会输出
    boolean isAdd(){
        return  true;
    }
}
//纯豆浆什么都不加
class PureSoyaMIlk extends  SoyaMilk{

    @Override
    void addCondiments() {
        //这里就是null实现 因为不需要加入任何的配料
        //即使是实现了在流程中也不会运行
    }

    @Override
    boolean isAdd() {
        return false;
    }
}
