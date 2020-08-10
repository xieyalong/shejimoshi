package com.xyl.模式.原型模式.深copy;

import java.io.*;
////序列化和反序列化
//public class Test {
//    public static void main(String[] args) throws CloneNotSupportedException {
//        DeepProtoTypepe p= new DeepProtoTypepe();
//        p.name="宋江";
//        p.deep=new Deep("大牛");
//        //使用序列化和反序列化深copy
//        DeepProtoTypepe p2=(DeepProtoTypepe)p.cloneObj();
//        System.out.println("p.name="+p.name+",p.deep.hashCode()="+p.deep.hashCode());
//        System.out.println("p2.name="+p2.name+",p2.deep.hashCode()="+p2.deep.hashCode());
//    }
//}
//
//class Deep implements  Cloneable, Serializable {
//    private  static  final long id=1L;
//    private  String cloneName;
//
//    public Deep(String cloneName) {
//        this.cloneName = cloneName;
//    }
//    //
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//}
//class DeepProtoTypepe implements Cloneable, Serializable {
//    //基本类型
//    public  String name;
//    //引用类型
//    public Deep deep;
//    //完成深copy实现 方式1 使用clone方法
//
//    //序列化和反序列化实现深copy
//    public  Object cloneObj(){
//        ByteArrayOutputStream bos=null;
//        ObjectOutputStream oos=null;
//        ByteArrayInputStream bis=null;
//        ObjectInputStream ois=null;
//        try {
//            //序列化 输出流 对DeepProtoTypepe的实例化输出
//            bos=new ByteArrayOutputStream();
//            oos=new ObjectOutputStream(bos);
//            //把当前对象 以对象流的方式输出
//            oos.writeObject(DeepProtoTypepe.this);
//
//            //反序列化 输入流 对DeepProtoTypepe的实例化输入 输出一个新的新的对象
//            bis=new ByteArrayInputStream(bos.toByteArray());
//            ois=new ObjectInputStream(bis);
//            DeepProtoTypepe deepProtoTypepe=(DeepProtoTypepe)ois.readObject();
//            return deepProtoTypepe;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }finally {
//            try {
//                bos.close();
//                oos.close();
//                bis.close();
//                ois.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

//clone方式
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoTypepe p= new DeepProtoTypepe();
        p.name="宋江";
        p.deep=new Deep("大牛");
        //使用clone深copy
        DeepProtoTypepe p2=(DeepProtoTypepe)p.clone();
        System.out.println("p.name="+p.name+",p.deep.hashCode()="+p.deep.hashCode());
        System.out.println("p2.name="+p2.name+",p2.deep.hashCode()="+p2.deep.hashCode());
    }
}

class Deep implements  Cloneable, Serializable {
    private  static  final long id=1L;
    private  String cloneName;

    public Deep(String cloneName) {
        this.cloneName = cloneName;
    }
    //
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class DeepProtoTypepe implements Cloneable, Serializable {
    //基本类型
    public  String name;
    //引用类型
    public Deep deep;
    //完成深copy实现 方式1 使用clone方法

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deepObj=null;
        //完成对基本数据类型的copy
        deepObj=super.clone();
        //处理引用类型的属性进行单独的处理
        DeepProtoTypepe deepProtoTypepe=(DeepProtoTypepe) deepObj;
        //把自己clone一下
        deepProtoTypepe.deep=(Deep)deep.clone();
        return deepObj;
    }
}