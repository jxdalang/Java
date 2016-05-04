/**
* @package headfirst_design_pattern
* @author ZS@ZJU
* @version V1.0
*/
package headfirst_design_pattern;

/**
* @className Singleton
* @description TODO
* @author ZS@ZJU
* @date Dec 21, 2015 3:19:13 PM
*/
public class Singleton {
    private volatile static Singleton uniqueInstance = null;

    private Singleton() {

    }

    // 双重检查加锁
    public Singleton getInstance() {
        if (uniqueInstance == null)
            synchronized (Singleton.class) {
                if (uniqueInstance == null) // 再次检查，这是因为进入同步块的过程中可能有其他线程已经创建了单例
                    uniqueInstance = new Singleton();
            }
        return uniqueInstance;
    }
}
