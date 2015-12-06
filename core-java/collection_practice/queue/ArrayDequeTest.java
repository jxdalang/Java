/**
* @package queue
* @author ZS@ZJU
* @version V1.0
*/
package queue;

import java.util.ArrayDeque;

/**
* @className ArrayQueueTest
* @description TODO
* @author ZS@ZJU
* @date Dec 5, 2015 10:16:18 AM
*/
public class ArrayDequeTest {
    
    public static void main(String[] args){
        
        //ArrayDeque是队列的数组实现，队列的链表实现是LinkedList
        //这两个类都实现了Deque接口（Queue的子接口），也就是说支持双端队列
        
        ArrayDeque<String> test_queue = new ArrayDeque<>();
        //在队头和队尾都可以添加元素，add等价于addLast都是在队尾加元素
        test_queue.addFirst("Amy");
        test_queue.addFirst("Bob");
        test_queue.addLast("Ryan");
        test_queue.addLast("Zulu");
        System.out.println(test_queue);
        
        //移除元素用poll或者remove
        System.out.println(test_queue.poll());  //poll等价于pollFirst，都是移除头部元素
        //test_queue.pollFirst();
        System.out.println(test_queue);
        
        //peek查看队头的元素，但不移除
        System.out.println(test_queue.peek());
        System.out.println(test_queue);
        
        
    }

}
