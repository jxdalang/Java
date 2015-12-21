/**
* @package star_buzz
* @author ZS@ZJU
* @version V1.0
*/
package star_buzz;

/**
* @className Espresso
* @description TODO
* @author ZS@ZJU
* @date Dec 11, 2015 11:29:04 PM
*/
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    /*
     * (non-Javadoc) description TODO
     * 
     * @return
     * 
     * @see star_buzz.Beverage#cost()
     */
    @Override
    public double cost() {
        // TODO Auto-generated method stub
        return 1.99;
    }

}
