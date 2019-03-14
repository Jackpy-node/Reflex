package cn.kpy.Reflex.FirstReflex;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: cn.kpy.Reflex.FirstReflex
 * @data: 2019/3/14 15:56
 * @discription: 利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 **/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Properties {
    public static void main(String[] args) {
        try {
            Class studentClass=Class.forName(getValue("ClassName"));
            Method method=studentClass.getMethod(getValue("MethodName"), String.class);
            Object object=studentClass.getConstructor(null).newInstance(null);
            method.invoke(object, "show1()");


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

    public static String getValue(String value){
        java.util.Properties properties=new java.util.Properties();
        try {
            FileReader fileReader=new FileReader("reflex.properties");
            properties.load(fileReader);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(value);
    }
}
