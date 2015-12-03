/**
* @package reflection_test
* @author ZS@ZJU
* @version V1.0
*/
package reflection_test;

/**
* @className getName_and_instantiation
* @description TODO
* @author ZS@ZJU
* @date Nov 29, 2015 11:10:29 AM
*/
public class Class_getName_and_getClassObject {
    public static void main(String[] args) {
        // 得到完整的类名
        Demo d = new Demo();
        System.out.println(d.getClass().getName());

        // 实例化Class类对象，所有类型的对象其实都是Class的实例
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        // 方法1（一般尽量采用这种形式）
        try {
            demo1 = Class.forName("reflection_test.Demo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 方法2
        demo2 = new Demo().getClass();
        // 方法3
        demo3 = Demo.class;

        System.out.println("classname = " + demo1.getName());
        System.out.println("classname = " + demo2.getName());
        System.out.println("classname = " + demo3.getName());
    }

}
