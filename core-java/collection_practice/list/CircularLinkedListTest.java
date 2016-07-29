/**
* @package list
* @author ZS@ZJU
* @version V1.0
*/
package list;

import java.util.LinkedList;
import java.util.List;

/**
 * 在一个total个元素的圈子里，从begin开始每隔一个元素删掉，返回最后剩下的元素
*/
public class CircularLinkedListTest {

    public static String lastOne(int total, int begin) {
        if (total < 1 || begin < 1 || begin > total) {
            return "Invalid";
        }
        // build circle
        List<String> circle = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            circle.add(String.valueOf(i + 1));
        }

        return remove(String.valueOf(begin), circle);
    }

    private static String remove(String current, List<String> circle) {
        if (circle.size() == 1) {
            return circle.get(0);
        } else {
            String next = circle.get((circle.indexOf(current) + 2) % circle.size());
            circle.remove(current);
            return remove(next, circle);
        }
    }

    /**
    * @description TODO
    * @param args 
    * @returnType void
    */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(CircularLinkedListTest.lastOne(10, 4));
        System.out.println(CircularLinkedListTest.lastOne(8, 3));
        System.out.println(CircularLinkedListTest.lastOne(5, 3));
    }

}
