package hash;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author KUMA
 * coin value-name map
 */
public class Coin {
    // fields
    private HashMap<Integer, String> coin = new HashMap<>();

    // constructor
    public Coin() {
        coin.put(1, "penny");
        coin.put(10, "dime");
        coin.put(25, "quarter");
        coin.put(50, "half-dollar");
    }

    // methods
    /**
     * @param amount
     *            value of the coin
     * @return name of the coin
     */
    public String getName(int amount) {
        if (coin.containsKey(amount))
            return coin.get(amount);
        else
            return "NOT FOUND";
    }

    /**
     * @return number of maps
     */
    public int showSetNum() {
        // keySet()返回键值的集合
        return coin.keySet().size();
    }

    /**
     * 
     */
    public void list() {
        // coin.toString
        System.out.println(coin);
    }

    /**
     * @return object content in string form
     */
    public String getString() {
        return coin.toString();
    }

    /**
     * @param args
     *            command arguments
     */
    public static void main(String[] args) {
        Coin c = new Coin();
        Scanner in = new Scanner(System.in);
        System.out.print("enter a key:");
        System.out.println("Name of coin is: " + c.getName(in.nextInt()));
        in.close();
        System.out.println("Num of HashMaps: " + c.showSetNum());
        c.list();
    }

}