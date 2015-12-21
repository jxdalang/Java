/**
* @package star_buzz
* @author ZS@ZJU
* @version V1.0
*/
package star_buzz;

/**
* @className Beverage
* @description TODO
* @author ZS@ZJU
* @date Dec 11, 2015 11:19:11 PM
*/
public abstract class Beverage {
    String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }
    
    public abstract double cost();
}
