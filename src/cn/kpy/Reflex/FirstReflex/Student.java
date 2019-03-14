package cn.kpy.Reflex.FirstReflex;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: cn.kpy.Reflex
 * @data: 2019/3/13 7:58
 * @discription: 学生类基类
 **/
public class Student {

    //字段
    public String name;
    protected int age;
    private String num;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", num='" + num + '\'' +
                '}';
    }

    //默认无参构造函数
    public Student() {
        System.out.println("无参构造函数");
    }

    //String类型构造函数
    public Student(String string) {
        System.out.println("公共的构造方法，参数类型String：" + string);
    }

    protected Student(boolean flag) {
        System.out.println("受保护的构造方法，参数类型boolean：" + flag);
    }

    private Student(int age) {
        System.out.println("私有的构造方法，参数类型int：" + age);
    }

    //成员方法
    public void show1(String string){
        System.out.println("调用公有的，String类型参数："+string);
    }

    protected void show2(){
        System.out.println("调用受保护的，无参函数");
    }

    void show3(){
        System.out.println("调用默认的，无参函数");
    }

    private String show4(int age){
        System.out.println("调用私有的，int类型参数："+age);
        return toString();
    }


}
