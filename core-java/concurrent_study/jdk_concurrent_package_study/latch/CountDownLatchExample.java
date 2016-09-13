/**
* @package jdk_concurrent_package_study.latch
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.latch;

import java.util.concurrent.CountDownLatch;

/**
CountDownLatch 是一个并发构造，它允许一个或多个线程等待一系列指定操作的完成。
CountDownLatch 以一个给定的数量初始化。countDown() 每被调用一次，这一数量就减一。
通过调用 await() 方法之一，线程可以阻塞等待这一数量到达零。
*/
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

        Thread.sleep(4000);
    }
}
