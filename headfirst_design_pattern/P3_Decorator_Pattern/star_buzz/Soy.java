/**
* @package star_buzz
* @author ZS@ZJU
* @version V1.0
*/
package star_buzz;

/**
* @className Soy
* @description TODO
* @author ZS@ZJU
* @date Dec 11, 2015 11:46:04 PM
*/
public class Soy extends Condiment {
    Beverage beverage;

    /**
    * @description TODO 
    */
    public Soy(Beverage beverage) {
        // TODO Auto-generated constructor stub
        this.beverage = beverage;
    }

    /*
     * (non-Javadoc) description TODO
     * 
     * @return
     * 
     * @see star_buzz.Condiment#getDescription()
     */
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return beverage.getDescription() + " + Soy";
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
        return beverage.cost() + 0.15;
    }

}
