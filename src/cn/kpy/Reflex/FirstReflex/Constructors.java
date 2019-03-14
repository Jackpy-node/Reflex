package cn.kpy.Reflex.FirstReflex;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: cn.kpy.Reflex.FirstReflex
 * @data: 2019/3/13 8:19
 * @discription: 通过反射机制获取class对象之后，获取对象的构造方法
 **/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员
 * 1、获取构造方法：
 *      1）、批量方式：
 *          public Constructor[] getConstructors()：所有"公有的"构造方法
 *          public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
 *      2）、获取单个构造方法，并调用
 *          public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法，需要传入目标构造方法的形参列表
 *          public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有
 *
 *          --调用构造方法
 *          Constructor -->  newInstance(Object... args)：传入参数值
 *          newInstance是 Constructor类的方法（管理构造函数的类），使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化
 * */
public class Constructors {
    public static void main(String[] args) {

        try {
            //1、加载Class对象
            Class studentClass = Class.forName("cn.kpy.Reflex.FirstReflex.Student");

            //2、调所有公共构造方法
            System.out.println("公共构造方法：");
            Constructor[] constructors = studentClass.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            //3、获取所有的构造方法(包括私有、受保护、默认、公有)
            System.out.println("获取所有的构造方法(包括私有、受保护、默认、公有)：");
            constructors = studentClass.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            //4、获取公有、无参构造函数
            System.out.println("获取公有、无参构造函数：");
            Constructor constructor=studentClass.getConstructor(null);
            System.out.println(constructor);

            //5、获取私有、带参构造方法并调用
            System.out.println("获取私有、带参构造方法并调用：");
            constructor=studentClass.getDeclaredConstructor(int.class);
            System.out.println(constructor);
            constructor.setAccessible(true);//暴力访问(忽略掉访问修饰符)
            constructor.newInstance(10);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
