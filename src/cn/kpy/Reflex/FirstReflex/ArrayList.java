package cn.kpy.Reflex.FirstReflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther: kpy
 * @version: 1.0
 * @Package: cn.kpy.Reflex.FirstReflex
 * @data: 2019-3-14 19:01
 * @discription: 通过反射越过泛型检查
 **/
public class ArrayList {
    public static void main(String[] args) {
        java.util.ArrayList<String> arrayList=new java.util.ArrayList();
        arrayList.add("aaa");
        arrayList.add("bbb");

        Class arrayClass=arrayList.getClass();
        try {
            Method method=arrayClass.getMethod("add", Object.class);
            method.invoke(arrayList, 100);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        for(Object object:arrayList){
            System.out.println(object);
        }
    }
}
