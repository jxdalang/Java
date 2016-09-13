/**
* @package jdk_concurrent_package_study.blocking_queue
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
BlockingQueue 具有 4 组不同的方法用于插入、移除以及对队列中的元素进行检查。如果请求的操作不能得到立即执行的话，每个方法的表现也不同。这些方法如下：
      抛异常        特定值       阻塞        超时
插入  add(o)        offer(o)    put(o)     offer(o, timeout, timeunit)
移除  remove(o)     poll(o)     take(o)    poll(timeout, timeunit)
检查  element(o)    peek(o)      

四组不同的行为方式解释：
抛异常：如果试图的操作无法立即执行，抛一个异常。
特定值：如果试图的操作无法立即执行，返回一个特定的值(常常是 true / false)。
阻塞：如果试图的操作无法立即执行，该方法调用将会发生阻塞，直到能够执行。
超时：如果试图的操作无法立即执行，该方法调用将会发生阻塞，直到能够执行，但等待时间不会超过给定值。返回一个特定值以告知该操作是否成功(典型的是 true / false)。
*/
public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(10000);
    }
}