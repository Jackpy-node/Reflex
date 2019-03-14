package cn.kpy.Reflex.FirstReflex;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: cn.kpy.Reflex.FirstReflex
 * @data: 2019/3/13 8:06
 * @discription: 该类中通过反射的三种方式获取Student类对象
 **/
public class FirstReflex {
    public static void main(String[] args) {

        /**
         * 获取Class对象的三种方式：
         * 1 Object ——> getClass()
         * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
         * 3 通过Class类的静态方法：forName（String  className）(常用)
         *
         */

        /**
         * 第一种：
         * 1、通过对象调用 getClass() 方法来获取,通常应用在：比如你传过来一个 Object类型的对象，而我不知道你具体是什么类，用这种方法
         */
        Student student = new Student();//new 产生一个Student对象，一个Class对象
        Class studentClass = student.getClass();////获取Class对象
        System.out.println("Class name：" + studentClass.getName());

        /**
         * 第二种：
         * 直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高这说明任何一个类都有一个隐含的静态成员变量 class
         */
        Class studentClass1=Student.class;
        System.out.println(studentClass==studentClass1);//判断通过这种方式获取的class对象是否与第一种方式一致

        /**
         *第三种：
         * 3、通过 Class 对象的 forName() 静态方法来获取，用的最多，但可能抛出 ClassNotFoundException 异常
         */
        try {
            Class studentClass2=Class.forName("cn.kpy.Reflex.FirstReflex.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(studentClass1==studentClass2);//判断通过这种方式获取的class对象是否与前两种方式一致

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
