/**
* @package jdk_concurrent_package_study.barrier
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.barrier;

import java.util.concurrent.CyclicBarrier;

/**
CyclicBarrier是一个所有线程必须等待的一个栅栏，直到所有线程都到达这里，然后所有线程才可以继续做其他事情。
满足以下任何条件都可以让等待CyclicBarrier的线程释放：
最后一个线程也到达CyclicBarrier(调用await())
当前线程被其他线程打断(其他线程调用了这个线程的interrupt()方法)
其他等待栅栏的线程被打断
其他等待栅栏的线程因超时而被释放，例如barrier.await(10, TimeUnit.SECONDS)
外部线程调用了栅栏的CyclicBarrier.reset()方法
*/
public class CyclicBarrierExample {
    public static void main(String[] args) {
        Runnable barrier1Action = new Runnable() {
            public void run() {
                System.out.println("BarrierAction 1 executed ");
            }
        };
        Runnable barrier2Action = new Runnable() {
            public void run() {
                System.out.println("BarrierAction 2 executed ");
            }
        };

        // CyclicBarrier支持一个栅栏行动，栅栏行动是一个Runnable实例，一旦最后等待栅栏的线程抵达，该实例将被执行
        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
        CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }
}
