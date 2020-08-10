package com.xyl.模式.原型模式;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        User u=new User();
        u.name="张三";
        User u2=u.cloneObj();
        System.out.println(u2.name);
        u2.name="李四";
        System.out.println(u.name);
    }
}
class  User implements Cloneable, Serializable {
    public  String name;
    public  User cloneObj(){
        ByteArrayOutputStream bos=null;
        ObjectOutputStream oos=null;
        ByteArrayInputStream bis=null;
        ObjectInputStream ois=null;
        try {
            //序列化 输出流 对DeepProtoTypepe的实例化输出
            bos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bos);
            //把当前对象 以对象流的方式输出
            oos.writeObject(User.this);

            //反序列化 输入流 对DeepProtoTypepe的实例化输入 输出一个新的新的对象
            bis=new ByteArrayInputStream(bos.toByteArray());
            ois=new ObjectInputStream(bis);
            User deepProtoTypepe=(User)ois.readObject();
            return deepProtoTypepe;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}