/**
* @package simUDuck
* @author ZS@ZJU
* @version V1.0
*/
package simUDuck;

/**
* @className ModelDuck
* @description TODO
* @author ZS@ZJU
* @date Dec 10, 2015 10:51:13 AM
*/
public class ModelDuck extends Duck {

    // constructor
    // 创建对象时绑定了特定的行为
    public ModelDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    /*
     * (non-Javadoc) description TODO
     * 
     * @see simUDuck.Duck#display()
     */
    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("I'm a model duck.");
    }

}
