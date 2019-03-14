package cn.kpy.Reflex.FirstReflex;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: cn.kpy.Reflex.FirstReflex
 * @data: 2019/3/14 8:25
 * @discription: 通过反射机制获取class对象之后，访问对象的成员方法
 **/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 获取成员方法并调用
 *      1、批量：
 *          1）、public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 *          2）、public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 *      2、获取单个：
 *          1）、public Method getMethod(String name,Class<?>... parameterTypes);公有方法
 *                                      参数说明：
 *                                      name : 方法名
 *                                      Class ... : 形参的Class类型对象
 *          2）、public Method getDeclaredMethod(String name,Class<?>... parameterTypes)；所有方法
 *                                              参数说明：
 *                                              name : 方法名
 *                                              Class ... : 形参的Class类型对象
 *          --调用方法：
 *          Method --> public Object invoke(Object obj,Object... args):
 *                                          参数说明：
 *                                          obj : 要调用方法的对象
 *                                          args:调用方式时所传递的实参
 * */
public class Methods {
    public static void main(String[] args) {
        try {
            Class studentClass=Class.forName("cn.kpy.Reflex.FirstReflex.Student");
            //1、获取所有的公有方法
            System.out.println("获取所有的公有方法：");
            Method[] methods=studentClass.getMethods();
            for(Method method:methods){
                System.out.println(method);
            }

            //2、获取所有的方法，包括私有的(不包括继承的)
            System.out.println("获取所有的方法，包括私有的(不包括继承的)：");
            methods=studentClass.getDeclaredMethods();
            for(Method method:methods){
                System.out.println(method);
            }

            //3、获取公有方法show1(String string)，并调用
            System.out.println("获取公有方法show1(String string)，并调用：");
            Method method=studentClass.getMethod("show1", String.class);
            System.out.println(method);

            //实例化Student对象
            Object object=studentClass.getConstructor(null).newInstance(null);
            System.out.println(object);

            //4、获取私有构造方法show4(int age)、并调用
            System.out.println("获取私有构造方法show4(int age)、并调用：");
            method=studentClass.getDeclaredMethod("show4", int.class);
            System.out.println(method);
            method.setAccessible(true);//暴力访问，解除私有限定
            object=method.invoke(object, 20);
            System.out.println(object);


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
