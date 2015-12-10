/**
* @package simUDuck
* @author ZS@ZJU
* @version V1.0
*/
package simUDuck;

/**
* @className Duck
* @description TODO
* @author ZS@ZJU
* @date Dec 10, 2015 10:17:57 AM
*/
public abstract class Duck {

    // 持有可变行为的域
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    // constructor
    public Duck() {

    }

    // methods
    public abstract void display();

    public void swim() {
        System.out.println("All ducks can swim,even decoys.");
    }

    // 可变的行为委托给实现了相应接口的类的对象
    public void performFly() {
        flyBehavior.fly();
    }

    // 可以在运行时调用设置行为的方法改变行为
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}
