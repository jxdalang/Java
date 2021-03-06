/**
* @package jdk_concurrent_package_study.exchanger
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {

    Exchanger<Object> exchanger = null;
    Object object = null;

    public ExchangerRunnable(Exchanger<Object> exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    public void run() {
        try {
            Object previous = this.object;

            this.object = this.exchanger.exchange(this.object);

            System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}