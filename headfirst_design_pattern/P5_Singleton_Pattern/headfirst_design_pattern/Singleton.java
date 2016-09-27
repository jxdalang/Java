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
public final class Singleton {
    private static volatile Singleton uniqueInstance = null;

    // private constructor preventing new instances being created
    private Singleton() {
    }

    // 1> double-checked locking
    public Singleton getInstance1() {
        if (uniqueInstance == null)
            synchronized (Singleton.class) {
                if (uniqueInstance == null) // 再次检查，这是因为进入同步块的过程中可能有其他线程已经创建了单例
                    uniqueInstance = new Singleton();
            }
        return uniqueInstance;
    }

    // 2> an alternate simpler and cleaner version
    // potentially lower concurrency in a multi-threaded environment:
    public static synchronized Singleton getInstance2() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // 3> eager initialization
    // (when always need an instance / the cost of creating the instance is low)
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance3() {
        return INSTANCE;
    }

    // 4> Initialization-on-demand holder idiom
    /**
     * {@link SingletonHolder} is loaded on the first execution of {@link Singleton#getInstance()} 
     * or the first access to {@link SingletonHolder#INSTANCE}, not before.
     */
    private static class SingletonHolder { // 静态内部类
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance4() {
        return SingletonHolder.INSTANCE;
    }

}
