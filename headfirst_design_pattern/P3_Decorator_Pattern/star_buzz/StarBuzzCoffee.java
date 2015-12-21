/**
* @package star_buzz
* @author ZS@ZJU
* @version V1.0
*/
package star_buzz;

/**
* @className StarBuzzCoffee
* @description TODO
* @author ZS@ZJU
* @date Dec 11, 2015 11:49:05 PM
*/
public class StarBuzzCoffee {

    /**
    * @description TODO
    * @param args 
    * @returnType void
    */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription()+" $" + beverage1.cost());
        
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()+" $" + beverage2.cost());
        
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription()+" $" + beverage3.cost());

    }

}
