/**
* @package simUDuck
* @author ZS@ZJU
* @version V1.0
*/
package simUDuck;

/**
* @className MallardDuck
* @description TODO
* @author ZS@ZJU
* @date Dec 10, 2015 10:45:40 AM
*/
public class MallardDuck extends Duck {

    // constructor
    // 创建对象时绑定了特定的行为
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    /*
     * (non-Javadoc) description TODO
     * 
     * @see simUDuck.Duck#display()
     */
    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("I'm a mallard duck.");
    }

}
