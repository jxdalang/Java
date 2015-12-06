/**

* @package set
* @author ZS@ZJU
* @version V1.0
*/
package set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
* @className TreeSetTest
* @description TODO
* @author ZS@ZJU
* @date Dec 5, 2015 10:14:50 AM
*/
public class TreeSetTest {

    public static void main(String[] args) {

        // 树集是有序集合，存储的元素必须实现Comparator接口，即含有compare方法
        Set<String> test_set = new TreeSet<>();

        // 无序插入的元素到遍历时就已经排序了（默认字符串是字母表顺序）
        test_set.add("Alice");
        test_set.add("Jane");
        test_set.add("Pete");
        test_set.add("Ryan");
        test_set.add("Baltimore");
        System.out.println(test_set);

        /*
         * 如果存储的对象没有实现Comparator接口，或者想使用新的排序方法时，可以将一个实现了Comparator接口的对象传给树集的构造器
         */
        // 这里传递的接口对象也叫函数对象，因为它只是起到比较函数持有者的作用
        // 函数对象通常定义为匿名内部类的实例
        Set<String> test_set2 = new TreeSet<>(new Comparator<String>() {

            // 这里自定义了String的排序方式，先按长度排，相同长度再按字母表顺序排
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length())
                    return -1;
                else if (o1.length() > o2.length())
                    return 1;
                else
                    // 这里绝对不能直接返回0，因为Set认为compare返回0的两个对象相同，只会存储一个，即导致长度相同的字符串被当成相同的对象
                    return o1.compareTo(o2);
            }
        });

        test_set2.add("Alice");
        test_set2.add("Jane");
        test_set2.add("Pete");
        test_set2.add("Ryan");
        test_set2.add("Baltimore");
        System.out.println(test_set2);

    }

}
