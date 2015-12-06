/**
* @package reflection_test
* @author ZS@ZJU
* @version V1.0
*/
package reflection_test;

import java.lang.reflect.*;

/**
* @className Reflection_look_inside_a_class
* @description TODO
* @author ZS@ZJU
* @date Nov 30, 2015 9:10:17 PM
*/
public class Reflection_look_inside_a_class {
    public static void main(String[] args) {

        // 建立一个测试的对象
        Person p = new Person("Ryan", 22);

        // 获得管理Person类对应的Class对象
        Class<?> c = null;
        try {
            c = Class.forName("reflection_test.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1-利用反射查看类的域
        Field[] fieldsOfPerson = c.getDeclaredFields();
        for (Field f : fieldsOfPerson) {
            System.out.println(f);
        }
        // 判断修饰符的情况
        try {
            Field f_name = c.getDeclaredField("name");
            System.out.println(Modifier.isPrivate(f_name.getModifiers()));
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 尝试访问域的值
        try {
            Field f_name = c.getDeclaredField("name");
            // 覆盖访问权限，本来访问受限的域会抛出IllegalAccessException
            f_name.setAccessible(true);
            System.out.println(f_name.get(p));
            // 修改域的值
            f_name.set(p, "ZS");
            System.out.println(f_name.get(p));
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 2-利用反射查看类的方法
        Method[] methodsOfPerson = c.getDeclaredMethods();
        for (Method m : methodsOfPerson) {
            System.out.println(m);
        }
        // 查看返回值或是类型
        try {
            Method m_toString =c.getDeclaredMethod("toString");
            System.out.println(m_toString.getReturnType().getName());
            Method m_setAge =c.getDeclaredMethod("setAge",int.class);
            for(Class<?> cl:m_setAge.getParameterTypes())
                System.out.println(cl.getName());
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
     // 3-利用反射调用任意方法
        try {
            Method m_toString2 =c.getDeclaredMethod("toString");
            System.out.println(m_toString2.invoke(p));  //相当于调用了p.toString()
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
