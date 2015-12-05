/**
* @package list
* @author ZS@ZJU
* @version V1.0
*/
package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
* @className ArrayListTest
* @description TODO
* @author ZS@ZJU
* @date Dec 5, 2015 10:14:14 AM
*/
public class ArrayListTest {

    public static void main(String[] args) {
        Integer[] test_array = { 1, 3, 7, -3, 0, 9 };

        /*
         * ArrayList和LinkedList的构造器都可以接受Collection<? extends E>类型的参数
         * 构造一个包含指定collection的元素的列表，这些元素是按照该collection的迭代器返回它们的顺序排列的
         * 
         * 不过不能直接接收数组作为构造器参数，所以一般对数组使用Arrays的静态方法asList返回一个List包装器
         * 这个包装器是一个视图对象，实现了List接口，自然也实现了Collection接口
         */
        List<Integer> test_list = new ArrayList<Integer>(Arrays.asList(test_array));
        System.out.println(test_list);
        Iterator<Integer> iter = test_list.iterator();

        for (int i = 0; i < 2; i++) {
            if (iter.hasNext())
                System.out.println(iter.next());
        }
        iter.remove();
        System.out.println(test_list);

        // 数组无变化
        for (int i : test_array) {
            System.out.print(i + " ");
        }
    }
}
