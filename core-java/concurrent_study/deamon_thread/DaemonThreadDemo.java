/**
* @package deamon_thread
* @author ZS@ZJU
* @version V1.0
*/
package deamon_thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
* @className DaemonThreadDemo
* @description TODO
* @author ZS@ZJU
* @date May 2, 2016 7:33:46 PM
*/
public class DaemonThreadDemo {

    /**
    * @description TODO
    * @param args 
    * @returnType void
    */
    public static void main(String[] args) {
        System.out.println("进入主线程：" + Thread.currentThread().getName());

        // 本例说明守护线程不应该分配IO等任务，因为主线程结束时守护线程也结束了，不管其任务有没有执行完毕
        Thread daemon = new Thread(new DaemonThread());
        daemon.setName("daemon");
        daemon.setDaemon(true); // 设置为守护线程
        daemon.start();

        // 一旦主线程接（main）收到用户输入，就会执行完毕（结束）
        Scanner in = new Scanner(System.in);
        in.next();

        System.out.println("退出主线程：" + Thread.currentThread().getName());
        in.close();
    }

}

class DaemonThread implements Runnable {

    // 守护线程的任务是每个1s向文件中写入一些内容
    @Override
    public void run() {
        System.out.println("进入守护线程：" + Thread.currentThread().getName());

        try {
            writeFile();
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("退出守护线程：" + Thread.currentThread().getName());
    }

    private void writeFile() throws UnsupportedEncodingException, IOException, InterruptedException {
        File f = new File("DaemonThreadWriteFile.txt");
        OutputStream os = new FileOutputStream(f, true);
        int count = 0;
        while (count < 999) {
            os.write(("word" + count + "\n").getBytes("utf-8"));
            System.out.println("守护线程" + Thread.currentThread().getName() + "向文件中写入word" + count);
            count++;
            Thread.sleep(1000);
        }
        os.close();
    }
}
