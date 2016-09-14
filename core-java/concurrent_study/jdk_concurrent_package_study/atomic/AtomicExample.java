/**
* @package jdk_concurrent_package_study.atomic
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {

        // boolean
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        System.out.println("value before set = " + atomicBoolean.getAndSet(false));
        System.out.println("value after set = " + atomicBoolean.get());
        // 当前值与期望值比较，相同则设置成第二个值
        atomicBoolean.compareAndSet(false, true);
        System.out.println("value after compareAndSet = " + atomicBoolean.get());

        System.out.println("---------------------------");

        // integer
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("execute getAndIncrement = " + atomicInteger.getAndIncrement());
        System.out.println("after getAndIncrement = " + atomicInteger.get());
        System.out.println("execute incrementAndGet = " + atomicInteger.incrementAndGet());
        System.out.println("after incrementAndGet = " + atomicInteger.get());
    }
}
