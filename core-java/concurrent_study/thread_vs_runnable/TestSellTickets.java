package thread_vs_runnable;

public class TestSellTickets {

    /**
    * @description TODO
    * @param args 
    * @returnType void
    */
    public static void main(String[] args) {
        // Thread方式创建线程
        // Thread mt1 = new SellTicketsThread("窗口1");
        // Thread mt2 = new SellTicketsThread("窗口2");
        // Thread mt3 = new SellTicketsThread("窗口3");

        // Runnable方式创建线程
        Runnable r = new SellTicketsRunnale();
        Thread mt1 = new Thread(r, "窗口1");
        Thread mt2 = new Thread(r, "窗口2");
        Thread mt3 = new Thread(r, "窗口3");

        // 启动线程
        mt1.start();
        mt2.start();
        mt3.start();
    }

}

class SellTicketsRunnale implements Runnable {
    private volatile Integer ticketsCount = 10;

    @Override
    public void run() {
        // 卖票
        while (true) {
            synchronized (ticketsCount) {
                if (ticketsCount > 0)
                    System.out.println(Thread.currentThread().getName() + "卖出了1张票，剩余票数为" + --ticketsCount + "张");
                else
                    break;
            }
        }
    }
}

class SellTicketsThread extends Thread {
    private int ticketsCount = 5;

    public SellTicketsThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // 卖票
        while (true) {
            if (ticketsCount > 0)
                System.out.println(Thread.currentThread().getName() + "卖出了1张票，剩余票数为" + --ticketsCount + "张");
            else
                break;
        }
    }
}
