package cn.kpy.Reflex.FirstReflex;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: cn.kpy.Reflex.FirstReflex
 * @data: 2019/3/13 8:47
 * @discription: 通过反射机制获取class对象之后，访问对象的成员变量
 **/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取成员变量并调用
 * 1、批量方式：
 *      1）、Field[] getFields():获取所有的"公有字段"
 *      2）、Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有
 * 2、获取单个：
 *      1）、public Field getField(String fieldName):获取某个"公有的"字段
 *      2）、public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 *      --成员变量赋值
 *      Field --> public void set(Object obj,Object value):
 *	                                参数说明：
 *	                                1.obj:要设置的字段所在的对象；
 *	                                2.value:要为字段设置的值；
 *
 *
 * */
public class Fields {
    public static void main(String[] args) {
        //1、加载Class对象
        try {
            Class studentClass = Class.forName("cn.kpy.Reflex.FirstReflex.Student");
            //1、获取所有的公共字段
            System.out.println("获取所有的公共字段：");
            Field[] fields = studentClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            //2、获取所有的字段(包括私有、受保护、默认的)
            System.out.println("获取所有的字段(包括私有、受保护、默认的)：");
            fields = studentClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            //3、获取某个公共字段，并调用
            System.out.println("获取某个公共字段，并调用：");
            Field field = studentClass.getField("name");
            Constructor constructor = studentClass.getConstructor(null);
            System.out.println(constructor);
            Object object = constructor.newInstance(null);
            field.set(object, "John");
            Student student = (Student) object;
            System.out.println("name：" + student.name);

            //4、获取私有字段，并调用
            System.out.println("获取私有字段，并调用：");
            Field field1=studentClass.getDeclaredField("num");
            field1.setAccessible(true);//暴力反射，解除私有限定
            field1.set(object, "13342457763");
            System.out.println(student);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
