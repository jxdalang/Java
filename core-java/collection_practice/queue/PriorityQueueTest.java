/**
* @package queue
* @author ZS@ZJU
* @version V1.0
*/
package queue;

import java.util.PriorityQueue;

/**
* @className PriorityQueueTest
* @description TODO
* @author ZS@ZJU
* @date Dec 5, 2015 10:15:58 AM
*/
public class PriorityQueueTest {
    public static void main(String[] args) {
        // 优先队列无论插入的顺序如何，队头的元素总是“最小”的
        // 优先队列并不是将所有元素排序，而是采用堆（heap）的结构
        // 和树集一样，优先队列也能接收自定义的比较器函数对象
        PriorityQueue<String> test_queue = new PriorityQueue<>();
        test_queue.add("Alice");
        test_queue.add("Jane");
        test_queue.add("Pete");
        test_queue.add("Ryan");
        test_queue.add("Baltimore");
        System.out.println(test_queue.peek());
        
        //优先队列的典型示例是任务调度

    }

}
