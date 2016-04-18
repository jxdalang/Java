/**
* @package encode
* @author ZS@ZJU
* @version V1.0
*/
package encode;

import java.io.UnsupportedEncodingException;

/**
* @className EncodeDemo
* @description TODO
* @author ZS@ZJU
* @date Apr 14, 2016 8:25:09 PM
*/
public class EncodeDemo {

    /**
    * @description TODO
    * @param args 
     * @throws UnsupportedEncodingException 
    * @returnType void
    */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        String s = "幕课 ABC";

        // 直接转换成字节序列用的是<<项目默认的编码>>
        byte[] byte1 = s.getBytes();
        System.out.print("default encoding sequence: ");
        for (byte b : byte1) {
            // 把字节以十六进制的方式显示，与0xff相与是因为只需要取最低的8位
            System.out.print(Integer.toHexString(b & 0xff) + ' ');
        }
        System.out.println();

        // 可以指定用什么编码转换成字节序列

        // utf-8中文占用3个字节，英文占用1个字节
        byte[] byte2 = s.getBytes("utf-8");
        System.out.print("utf-8 encoding sequence: ");
        for (byte b : byte2) {
            // 把字节以十六进制的方式显示，与0xff相与是因为只需要取最低的8位
            System.out.print(Integer.toHexString(b & 0xff) + ' ');
        }
        System.out.println();

        // gbk中文占用2个字节，英文占用1个字节
        byte[] byte3 = s.getBytes("gbk");
        System.out.print("gbk encoding sequence: ");
        for (byte b : byte3) {
            // 把字节以十六进制的方式显示，与0xff相与是因为只需要取最低的8位
            System.out.print(Integer.toHexString(b & 0xff) + ' ');
        }
        System.out.println();

        // utf-16be中文占用2个字节，英文占用2个字节
        byte[] byte4 = s.getBytes("utf-16be");
        System.out.print("utf-16be encoding sequence: ");
        for (byte b : byte4) {
            // 把字节以十六进制的方式显示，与0xff相与是因为只需要取最低的8位
            System.out.print(Integer.toHexString(b & 0xff) + ' ');
        }
        System.out.println();

        /**
         * 总结： 
         * 1.java语言本身是双字节编码，使用utf-16be 
         * 2.当字节序列使用某种编码方式时，将其转化为字符串时也要使用一致的编码方式
         * 3.文本文件中存放的可以是任意字节序列，对其处理时要注意其编码方式
         */

        System.out.println("已知字节序列byte2是utf-8编码，下面使用不同的编码方式转化：");
        String str1 = new String(byte2, "utf-8");
        String str2 = new String(byte2, "gbk");
        String str3 = new String(byte2, "utf-16be");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

    }

}
