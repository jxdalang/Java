/**
* @package simUDuck
* @author ZS@ZJU
* @version V1.0
*/
package simUDuck;

/**
* @className Test
* @description TODO
* @author ZS@ZJU
* @date Dec 10, 2015 10:53:03 AM
*/
public class Test {

    public static void main(String[] args) {
        // 面向接口编程，使用接口类型变量保存对象
        Duck modelduck = new ModelDuck();
        modelduck.display();
        modelduck.performQuack();
        modelduck.performFly();
        // 在运行时改变对象的行为
        System.out.println("Now I'm equipped with rocket.");
        modelduck.setFlyBehavior(new FlyWithRocket());
        modelduck.performFly();
    }
}
