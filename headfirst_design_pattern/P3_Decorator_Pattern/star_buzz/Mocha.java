/**
* @package star_buzz
* @author ZS@ZJU
* @version V1.0
*/
package star_buzz;

/**
* @className Mocha
* @description TODO
* @author ZS@ZJU
* @date Dec 11, 2015 11:35:41 PM
*/
public class Mocha extends Condiment {
    Beverage beverage;

    /**
    * @description TODO 
    */
    public Mocha(Beverage beverage) {
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
        return beverage.getDescription()+" + Mocha";
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
        return beverage.cost()+0.20;
    }

}
