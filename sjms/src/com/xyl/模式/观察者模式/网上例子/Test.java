package com.xyl.模式.观察者模式.网上例子;

import org.omg.CORBA.Object;

import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        //注意：如果多个类之间的信息通讯
        // 那么需要把观察者模式封装到一个单利里面
        //具体使用查看“16.80-观察者模式-在Android中的使用-两个activity之间的通讯-两个类之间相互通讯”

        //创建一个主题
        Subject subject = new Subject();
        //把观察者增加到主题内
        subject.register(new MyObserver());
        subject.register(new My2Observer());
        //主题发送消息后 my和my2都会接收到通知信息
        subject.setData("aaaaa");
    }
}

//主题(变动因子)
// 主体是管理观察者
//用Vector是线程同步的，比较安全，也可以使用ArrayList，是线程异步的，但不安全
class Subject {
    //观察者数组
    // 如果通知单个观察者，而不是遍历所有观察者
    //这里可以Map<String,Observer> map=new Hashtable<>();
    private List<Observer> oVector = new Vector<>();

    //增加观察者
    public void register(Observer observer) {
        this.oVector.add(observer);
    }

    //删除观察者
    public void remove(Observer observer) {
        this.oVector.remove(observer);
    }
    //设置数据
    public  void setData(String data){
        //数据改变后通知观察者接收数据
        notifyObserver(data);
    }
    //通知所有观察者
    //这里的通知观察值 主要是遍历所有的元素
    //给所有元素添加数据
    private void notifyObserver(String data) {
        for(Observer observer : this.oVector) {
            observer.update(data);
        }
    }
}


//观察者Observer
//观察变动因子
interface  Observer{
    //变动因子变动后 会及时的被调用
    //my和my2 都会受到通知
    void update(String data);
}
//my观察者
class  MyObserver implements  Observer{
    @Override
    public void update(String data) {
        System.out.println("my接受消息："+data);
    }
}
//my2观察者
class  My2Observer implements  Observer{
    @Override
    public void update(String data) {
        System.out.println("my2接受消息："+data);
    }
}
