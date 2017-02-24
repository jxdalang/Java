package threadobj_as_lock;

// 当一个线程对象被锁住后，线程运行结束的时候，notify是被线程的子系统调用的
// 因此其他被阻塞在这个锁对象上的线程都可以继续执行

// 这也是为什么join()方法底层是wait，但执行join的线程对象完毕后，无需notify其他等待线程
// join -> while (isAlive()) {wait(0);}

public class ThreadObjLock {
    public static void main(String[] args) {

        final MyLockThread o = new MyLockThread();
        final Object oo = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    System.err.println("Before wait | thread lock.");
                    try {
                        o.wait(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println("After wait (without notify) | thread lock.");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (oo) {
                    System.err.println("Before wait | normal lock.");
                    try {
                        oo.wait(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println("After wait (without notify) | normal lock.");
                }
            }
        }).start();

        o.start();
    }

    static class MyLockThread extends Thread {

        public MyLockThread() {
        }

        @Override
        public void run() {
            System.err.println("MyLockThread RUN.");
        }

        // After run() finishes, notify() is called by the Thread subsystem.

    }
}