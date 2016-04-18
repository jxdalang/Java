/**
* @package inpu_output_stream
* @author ZS@ZJU
* @version V1.0
*/
package inpu_output_stream;

import java.io.File;
import java.io.IOException;

public class testIOUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            long start = System.currentTimeMillis();
//            IOUtil.copyFileWithBuffer(new File("F:\\Mass Relay\\javaio\\1.mp3"),
//                    new File("F:\\Mass Relay\\javaio\\2.mp3")); // 9毫秒
//            IOUtil.copyFile(new File("F:\\Mass Relay\\javaio\\1.mp3"), new File("F:\\Mass Relay\\javaio\\3.mp3")); // 9毫秒
//            IOUtil.copyFileWithBufferByByte(new File("F:\\Mass Relay\\javaio\\1.mp3"),
//                    new File("F:\\Mass Relay\\javaio\\4.mp3"));// 10000毫秒左右
            IOUtil.copyFileByByte(new File("F:\\Mass Relay\\javaio\\1.mp3"), new File("F:\\Mass Relay\\javaio\\5.mp3")); // 16000毫秒以上
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
