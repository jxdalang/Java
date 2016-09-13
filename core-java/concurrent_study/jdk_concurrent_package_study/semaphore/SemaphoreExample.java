/**
* @package jdk_concurrent_package_study.semaphore
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.semaphore;

import java.util.concurrent.Semaphore;

/**
计数信号量由一个指定数量的 "许可" 初始化。每调用一次 acquire()，一个许可会被调用线程取走。
每调用一次 release()，一个许可会被返还给信号量。
信号量主要有两种用途：
1.保护一个重要(代码)部分防止一次超过 N 个线程进入。
2.在两个线程之间发送信号
如果你将一个信号量用于在两个线程之间传送信号，通常你应该用一个线程调用 acquire() 方法，而另一个线程调用 release() 方法。
如果没有可用的许可，acquire() 调用将会阻塞，直到一个许可被另一个线程释放出来。同理，如果无法往信号量释放更多许可时，一个 release() 调用也会阻塞。
通过这个可以对多个线程进行协调。比如，如果线程 1 将一个对象插入到了一个共享列表(list)之后之后调用了 acquire()，
而线程 2 则在从该列表中获取一个对象之前调用了 release()，这时你其实已经创建了一个阻塞队列。
信号量中可用的许可的数量也就等同于该阻塞队列能够持有的元素个数。
 */
public class SemaphoreExample {
    
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);

        // critical section
        semaphore.acquire();
        
        // DO SOMETHING

        semaphore.release();

    }

}
