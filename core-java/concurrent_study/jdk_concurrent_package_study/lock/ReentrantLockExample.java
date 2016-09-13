/**
* @package jdk_concurrent_package_study.lock
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        lock.lock();

        // critical section

        lock.unlock();
    }
}
