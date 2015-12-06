/**
* @package list
* @author ZS@ZJU
* @version V1.0
*/
package list;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
* @className LinkedListTest
* @description TODO
* @author ZS@ZJU
* @date Dec 5, 2015 10:13:56 AM
*/
public class LinkedListTest {
    public static void main(String[] args) {

        // 链表的优势在于在中间位置增删元素比较快，缺点是不能随机访问
        List<String> test_list = new LinkedList<>();

        // LinkedList.add方法在链表的尾部添加元素
        test_list.add("Amy");
        test_list.add("Carl");
        test_list.add("Bob");
        test_list.add("Ryan");
        System.out.println(test_list);

        // listIterator迭代器含有add方法，可以在当前位置添加元素
        ListIterator<String> iter = test_list.listIterator();
        ListIterator<String> iter2 = test_list.listIterator();

        iter.next();
        iter.next();
        iter.add("John");   //注意不是test_list.add
        System.out.println(test_list);

        // listIterator迭代器含有remove方法，remove的元素是迭代器刚刚越过的
        iter.next();
        iter.next();
        iter.previous();
        iter.remove();
        System.out.println(test_list);

        // 如果有多个迭代器，可能会发生并发修改的错误，抛出异常
        // 原则：多个只读迭代器，一个可读写的迭代器
        try {
            System.out.println(iter2.next());
        } catch (ConcurrentModificationException e) {
            System.out.println("catched ConcurrentModificationException");
        }

    }

}
