/**
* @package reflection_test
* @author ZS@ZJU
* @version V1.0
*/
package reflection_test;

import java.lang.reflect.Constructor;

/**
* @className Class_newInstance
* @description TODO
* @author ZS@ZJU
* @date Nov 29, 2015 11:31:12 AM
*/
public class Class_newInstance {
    public static void main(String[] args) {

        //首先获得类对应的Class对象
        Class<?> c = null;
        try {
            c = Class.forName("reflection_test.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 方法1：通过newInstance调用默认构造器实例化其他类的对象
        Person p1 = null;
        try {
            // newInstance调用的是无参构造器，如果没有该构造器会抛出InstantiationException
            p1 = (Person) c.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p1.setName("Rollen");
        p1.setAge(20);
        System.out.println(p1);

        // 方法2：通过getConstructor调用其他类中的构造器创建其他类的对象
        Person p2 = null;
        Constructor<?> cons = null;
        try {
            // 取得特定参数的构造器
            cons = c.getConstructor(String.class, int.class);
            // 查看取得的构造器
            System.out.println(cons.toString());
        } catch (NoSuchMethodException | SecurityException e1) {
            e1.printStackTrace();
        }
        try {
            // 尝试用取得的构造器创建对象
            p2 = (Person) cons.newInstance("Ryan", 22);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查看对象是否成功创建
        System.out.println(p2);
    }

}
