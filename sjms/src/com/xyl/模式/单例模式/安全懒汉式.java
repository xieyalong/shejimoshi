package com.xyl.模式.单例模式;//package com.xyl.模式.单例模式;
//
public class 安全懒汉式 {
    public static void main(String[] args) {
    }
}
//使用  Singletion.instance.aa();
enum  Singletion{
    instance;//属性
    public void aa(){}
}
//class Singletion{
//    private  Singletion(){}
//    //内部类中实例化对象
//    private static  class SingInstance{
//        private  static final   Singletion SINGLETION=new Singletion();
//    }
//    public static  Singletion getInstance() {
//        return SingInstance.SINGLETION;
//    }
//}
//class Singleton3{
//    //1，创建私有构造
//    private Singleton3(){}
//    //2,私有静态的变量  volatile能立马感知数据修改了
//    private static volatile   Singleton3 instance;
//    //3,共有静态的方法 在使用的时候才去创建对象
//    public static  Singleton3 getInstance() {
//        //当a线程进到第二层判断时，其他线程还在等待，a线程实例化此对象后，instance会立马感知
//        //这个时候b线程在二层判断时候发现已经实例化，return instance
//        //当c，d线程到第一次判断时候发现已经实例化，就不用再继续往下走，直接return，保证了效率
//        //这样就永远保证了对象的唯一
//        if (null==instance){//第一次判断
//            synchronized(Singleton3.class){
//                if (null==instance){//第二次判断
//                    instance=new Singleton3();
//                }
//            }
//        }
//        return instance;
//    }
//}

//class Singleton3{
//    //1，创建私有构造
//    private Singleton3(){}
//    //2,私有静态的变量
//    private static  Singleton3 instance;
//    //3,共有静态的方法 在使用的时候才去创建对象 加入同步
//    public static  Singleton3 getInstance() {
//        if (null==instance){
//            synchronized(Singleton3.class){
//                instance=new Singleton3();
//            }
//        }
//        return instance;
//    }
//}
//class Singleton3{
//    //1，创建私有构造
//    private Singleton3(){}
//    //2,私有静态的变量
//    private static  Singleton3 instance;
//    //3,共有静态的方法 在使用的时候才去创建对象 加入同步
//    public static synchronized Singleton3 getInstance() {
//        if (null==instance){
//            instance=new Singleton3();
//        }
//        return instance;
//    }
//}

