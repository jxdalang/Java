/**
* @package jdk_concurrent_package_study.exchanger
* @author ZS@ZJU
* @version V1.0
*/
package jdk_concurrent_package_study.exchanger;

import java.util.concurrent.Exchanger;

/**
Exchanger类表示一种两个线程可以进行互相交换对象的会和点
交换对象的动作由 Exchanger 的两个 exchange() 方法的其中一个完成
*/
public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Object> exchanger = new Exchanger<Object>();

        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
    }
}
