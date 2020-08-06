package com.xyl.里氏替换原则;
public class Test {
    public static void main(String[] args) {
        B b=new B();
        b.func2(3,2);
    }
}

/**
 * 改进
 * 1，创建一个更加基础的类，
 * 2，让所有类都继承基础类
 * 3，让B类继承基础类和A类组合
 */
class Base{ }
class  A extends Base{
    //父类的本意是减法
    public int func1(int num1,int num2){
        return num1-num2;
    }
}
class  B extends Base{
    //这是组合方式
    private  A a=new A();
    public void func2(int a,int b){
        //这样fanc1减法就不容易导致方法错乱，永远都是它的本意
        int num= this.a.func1(a,b)+10;
        System.out.println(num);
    }
}







//public class Test {
//    public static void main(String[] args) {
//        B b=new B();
//        b.func2(3,2);
//    }
//}
//class  A{
//    //父类的本意是减法
//    public int func1(int num1,int num2){
//        return num1-num2;
//    }
//}
//class  B extends A{
//    //到了子类就变成了加法
//    //造成了偏离了原有的功能，
//    //导致整个继承体系比较差，如有类在继承了B
//    @Override
//    public int func1(int num1, int num2) {
//        return num1+num2;
//    }
//    public void func2(int a,int b){
//        int num= func1(a,b)+10;
//        System.out.println(num);
//    }
//}