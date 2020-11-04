package com.xyl.模式.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
      ITeacherDao pi= (ITeacherDao) new ProxyFactory(new TeacherDao()).getProxyInstance();
      //查看代理的对象是哪个？
        //TeacherDao（pi是目标类）-------$Proxy0(说明是代理对象)
        System.out.println(pi+"---"+pi.getClass());
        pi.teach();
        pi.say("tom");
    }
}

//接口
interface ITeacherDao{
    void  teach();//授课方法
    void say(String name);
}
//目标类
class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println("授课中");
    }

    @Override
    public void say(String name) {
        System.out.println("name="+name);
    }
}
//工程类
class ProxyFactory{
    //维护一个目标对象Object
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    //给目标对象生成一个代理对象
    public Object getProxyInstance(){
        //loader指定当前目标对象使用的类的加载器，获取加载器的方法固定
        //interfaces：目标对象实现的所有接口类型，使用泛型方式确认类型
        //h：事件处理，执行目标对象的方法事，会出发处理器方法，会把当前执行目标对象方法作为参数传入
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("jdk代理开始");
                        //proxy目标类
                        //method；就是方法teach（）和
                        //args 参数
                        //通过反射机制，调用目标对象的方法target.teach（）和say(String name)等
                      Object objectVal= method.invoke(target,args);
                        System.out.println("jdk代理 提交");
                        return objectVal;
                    }
                });
    }
}
//接口
interface Itf{
    void show();
}
//目标对象
class MuBiao implements Itf {
    @Override
    public void show() {
        System.out.println("目标对象的功能");
    }
}
//代理对象
class Proxy_{
    //目标对象
    private Object target;
    public Proxy_(Object target) {
        this.target = target;
    }

    //给目标对象生成一个代理对象
    //调用：
    // Itf itf=(Itf) new Proxy_(new MuBiao()).getProxyInstance();
    // show()在method.invoke(target,args);时候运行的
    // itf.show();
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    //proxy,target,objectVal=MuBiao(目标对象)
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("jdk代理扩展");
                        Object objectVal= method.invoke(target,args);//运行目标对象的方法
                        System.out.println("jdk代理扩展");
                        return objectVal;
                    }
                });
    }
}