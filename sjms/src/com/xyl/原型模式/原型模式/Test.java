package 原型模式;

public class Test {
}
class  Client{
    public static void main(String[] args) {
        Sheep sheep=new Sheep("tom",1,"白色");
        //不用再new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep1=(Sheep)sheep.clone();
        Sheep sheep2=(Sheep)sheep.clone();
    }
}

//羊
class  Sheep implements Cloneable{
    private  String name;
    private int age;
    private  String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
    //重写克隆
    @Override
    protected Object clone(){
        Sheep sheep=null;
        try {
            sheep=(Sheep) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }


        return sheep;
    }
}