package com.xyl.模式.代理模式.静态代理;

//客户端 不直接调用目标对象，让代理来调用目标对象
public class Test {
    public static void main(String[] args) {
        new TeacherDaoProxy(new TeacherDao()).teach();
    }
}

//接口
interface ITeacherDao{
    void teach();
}
//目标对象 实现接口
class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("老师授课中");
    }
}

//代理对象
class TeacherDaoProxy implements ITeacherDao{
    //把目标对象聚合到代理对象里面
    private TeacherDao teacherDao;

    public TeacherDaoProxy(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("开始代理 完成某些操作");//额外功能 其他功能 如验证权限够不够等
        teacherDao.teach();//可以代理很多不同的对象
        System.out.println("提交 完成某些操作");//额外功能
    }
}
