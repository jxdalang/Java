/**
* @package inpu_output_stream
* @author ZS@ZJU
* @version V1.0
*/
package inpu_output_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
    /**
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且每输出10个byte换行
     * @param fileName
     * 单字节读取不适合大文件，大文件效率很低
     */
    public static void printHex(String fileName) throws IOException {
        // 把文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            if (b <= 0xf) {
                // 如果字节可以用一位16进制数表示，则前面补0(对齐)
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + "  ");

            // 每打印10字节个换行
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 批量读取，对大文件而言效率高，也是我们最常用的读文件的方式
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[8 * 1024];
        /**
         * 从in中批量读取字节，放入到buf这个字节数组中， 
         * 从第0个位置开始放，最多放buf.length个
         * 返回的是读到的字节的个数
         */
        int bytes = 0;
        int j = 1;
        while ((bytes = in.read(buf, 0, buf.length)) != -1) {
            // 打印读取到的数据
            for (int i = 0; i < bytes; i++) {
                System.out.print(Integer.toHexString(buf[i] & 0xff) + "  ");
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
        in.close();
    }

    /**
     * 字节批量读取，带缓冲进行文件拷贝
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileWithBuffer(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        InputStream in = new BufferedInputStream(new FileInputStream(srcFile));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();
        }
        in.close();
        out.close();
    }

    /**
     * 字节批量读取，不带缓冲进行文件拷贝，和上面方法耗时差不多
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        InputStream in = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();
        }
        in.close();
        out.close();
    }

    /**
     * 单字节，利用带缓冲（Buffered）的字节流进行文件拷贝
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileWithBufferByByte(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        InputStream is = new BufferedInputStream(new FileInputStream(srcFile));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));
        int c;
        while ((c = is.read()) != -1) {
            os.write(c);
            os.flush();// 刷新缓冲区
        }
        is.close();
        os.close();
    }

    /**
     * 单字节，不带缓冲进行文件拷贝
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        InputStream in = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(destFile);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
            out.flush();
        }
        in.close();
        out.close();
    }

}
