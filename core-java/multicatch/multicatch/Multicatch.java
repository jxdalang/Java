/**
* @package multicatch
* @author ZS@ZJU
* @version V1.0
*/
package multicatch;

/**
* @className Multicatch
* @description TODO
* @author ZS@ZJU
* @date Nov 20, 2015 4:05:29 PM
*/
public class Multicatch {

    /**
    * @description TODO
    * @param args 
    * @returnType void
    */
    public static void main(String[] args) {

        try {
            System.out.println("entered main");
            method1();
        } catch (NullPointerException e) {
            System.out.println("main catched NullPointerException");
        } catch (Exception e) {
            System.out.println("catched Exception");
        }
    }

    public static void method1() throws NullPointerException {
        try {
            System.out.println("entered method1");
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("method1 catched IllegalArgumentException");
            // 下面抛出的异常不会被下面的语句捕获，而是会被main中的catch捕获
            throw new NullPointerException();
        } catch (NullPointerException e) {
            // 这个catch语句块不会被执行
            System.out.println("method1 catched NullPointerException");
        }

    }

}
