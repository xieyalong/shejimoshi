package com.xyl.模式.迭代器模式.规范;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 规范 {
    public static void main(String[] args) {
        DataItf dataItf=new DataImpl();
        Iterator iterator=dataItf.creteIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

/**
 * 迭代器模式概念：
 * 模式概念模式分两个模块：迭代器和数据，
 * 迭代器只做遍历操作，数据只做数据的生成，
 * 而数据不向外暴露只隐藏在迭代器里面，
 * 迭代器向外暴露供客户端使用
 */

//迭代器模块
class MyIterator implements Iterator{
    //可以把string看做一个实体bean
    //string将会聚合到数据模块的实现类中
    List<String> list;
    int index=0;
    public MyIterator(List<String> list) {
        this.list = list;
    }
    //判断是否有下一个数据 没有返回false
    @Override
    public boolean hasNext() {
        if (index>list.size()-1){
            return false;
        }
        return true;
    }
    //获取当前的数据
    @Override
    public Object next() {
        String str=list.get(index);
        index++;
        return str;
    }

    @Override
    public void remove() { }
}
//数据模块
interface DataItf{
    Iterator creteIterator();
}
//数据的实现类
class  DataImpl implements DataItf{
    //聚合String 这里string可看做一个实体bean
    List<String> list;

    public DataImpl() {
        //模拟在内部模式初始化数据
        this.list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add("i="+i);
        }
    }

    @Override
    public Iterator creteIterator() {
        //把数据传递给迭代器给其遍历操作
        return new MyIterator(list);
    }

}
