/**
* @package jdk_concurrent_package_study.executor
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // create executors
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);

        Runnable runnable_task1 = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " says: runnable_task1 done.");
            }
        };
        Runnable runnable_task2 = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " says: runnable_task2 done.");
            }
        };
        Callable<String> callable_task1 = new Callable<String>() {
            public String call() {
                System.out.println(Thread.currentThread().getName() + " says: Do callable_task1.");
                return "callable_task1 done.";
            }
        };
        Callable<String> callable_task2 = new Callable<String>() {
            public String call() {
                System.out.println(Thread.currentThread().getName() + " says: Do callable_task2.");
                return "callable_task2 done.";
            }
        };
        Callable<String> callable_task3 = new Callable<String>() {
            public String call() throws InterruptedException {
                System.out.println(Thread.currentThread().getName() + " says: Start callable_task3.");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " says: callable_task3 done.");
                return "callable_task3 done.";
            }
        };
        Callable<String> callable_task4 = new Callable<String>() {
            public String call() throws InterruptedException {
                System.out.println(Thread.currentThread().getName() + " says: Start callable_task4.");
                Thread.sleep(1500);
                System.out.println(Thread.currentThread().getName() + " says: callable_task4 done.");
                return "callable_task4 done.";
            }
        };

        System.out.println(Thread.currentThread().getName() + " says: main task-1 done.");
        System.out.println(Thread.currentThread().getName() + " says: main task-2 done.");

        // execute()
        executorService1.execute(runnable_task1);

        System.out.println(Thread.currentThread().getName() + " says: main task-3 done.");
        System.out.println(Thread.currentThread().getName() + " says: main task-4 done.");
        System.out.println(Thread.currentThread().getName() + " says: main task-5 done.");

        // submit()
        // Future.get是阻塞的
        Future<?> runnable_task2_future = executorService2.submit(runnable_task2);
        System.out.println("runnable_task2_future = " + runnable_task2_future.get());
        Future<?> callable_task1_future = executorService2.submit(callable_task1);
        if (callable_task1_future.isDone())
            System.out.println("callable_task1_future = " + callable_task1_future.get());
        else
            System.out.println("callable_task1 hasn't done.");
        Future<?> callable_task2_future = executorService2.submit(callable_task2);
        System.out.println("callable_task2_future = " + callable_task2_future.get());

        System.out.println(Thread.currentThread().getName() + " says: main task-6 done.");

        // invokeAny()
        List<Callable<String>> callable_list = new ArrayList<Callable<String>>();
        callable_list.add(callable_task3);
        callable_list.add(callable_task4);
        // invokeAny并不是挑一个task执行，只要线程池有空余的worker就会执行task，只不过有task完成后，其他的都会被取消
        String invokeAny_result = executorService2.invokeAny(callable_list);
        System.out.println("invokeAny_result = " + invokeAny_result);

        System.out.println(Thread.currentThread().getName() + " says: main task-7 done.");

        // invokeAll()
        List<Future<String>> invokeAll_future_list = executorService2.invokeAll(callable_list);

        System.out.println(Thread.currentThread().getName() + " says: main task-8 done.");

        for (Future<?> future : invokeAll_future_list) {
            System.out.println("future = " + future.get());
        }

        System.out.println(Thread.currentThread().getName() + " says: main task-9 done.");

        // shutdown executors
        executorService1.shutdown();
        executorService2.shutdown();
    }

}
