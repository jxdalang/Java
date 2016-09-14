/**
* @package jdk_concurrent_package_study.executor
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // create executors
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Callable<String> callable_task1 = new Callable<String>() {
            public String call() {
                System.out.println(Thread.currentThread().getName() + " says: Do callable_task1.");
                return "callable_task1 done.";
            }
        };
        Callable<String> callable_task2 = new Callable<String>() {
            public String call() throws InterruptedException {
                System.out.println(Thread.currentThread().getName() + " says: Start callable_task2.");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " says: callable_task2 done.");
                return "callable_task2 done.";
            }
        };
        Runnable runnable_task = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " says: Start runnable_task.");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " says: runnable_task done.");
            }
        };

        System.out.println(Thread.currentThread().getName() + " says: main task-1 done.");

        // schedule()
        ScheduledFuture<?> scheduledFuture1 = executorService.schedule(callable_task1, 3, TimeUnit.SECONDS);
        // scheduled task can be cancelled
        scheduledFuture1.cancel(false);
        if (scheduledFuture1.isCancelled())
            System.out.println("callable_task1 cancalled");

        System.out.println(Thread.currentThread().getName() + " says: main task-2 done.");

        ScheduledFuture<?> scheduledFuture2 = executorService.schedule(callable_task2, 1, TimeUnit.SECONDS);

        System.out.println(Thread.currentThread().getName() + " says: main task-3 done.");

        Thread.sleep(1500);

        if (scheduledFuture2.isDone())
            System.out.println("scheduledFuture2 = " + scheduledFuture2.get());
        else
            System.out.println("callable_task2 hasn't done.");

        System.out.println(Thread.currentThread().getName() + " says: main task-4 done.");

        // scheduleAtFixedRate()
        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(runnable_task, 1, 2, TimeUnit.SECONDS);
        if (scheduledFuture.isDone())
            System.out.println("scheduledFuture = " + scheduledFuture.get());
        else
            System.out.println("runnable_task hasn't done.");

        System.out.println(Thread.currentThread().getName() + " says: main task-5 done.");

        Thread.sleep(10000);

        System.out.println(Thread.currentThread().getName() + " says: main task-6 done.");

        // shutdown executors
        // 当executor中还有定时task，会等待最后的task执行完，但不会再开始之后的定时任务
        executorService.shutdown();
    }
}
