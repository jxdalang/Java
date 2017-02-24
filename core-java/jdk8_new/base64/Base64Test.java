package base64;

import java.nio.charset.StandardCharsets;
//对Base64编码的支持已经被加入到Java 8官方库中
import java.util.Base64;

public class Base64Test {

    /**
     * Base64是一种任意二进制到文本字符串的编码方法，常用于在URL、Cookie、网页中传输少量二进制数据。
     * ['A', 'B', 'C', ... 'a', 'b', 'c', ... '0', '1', ... '+', '/']
     * Base64编码会把3字节的二进制数据根据上表编码为4字节的文本数据，
     * 3字节拆分成4个6bit的数，这些数字作为索引查表，获得相应的4个字符。
     * 标准的Base64编码后可能出现字符+和/，"url safe"的base64编码，其实就是把字符+和/分别变成-和_。
     * 很多Base64编码后会把=去掉，只需要加上=把Base64字符串的长度变为4的倍数，就可以正常解码了。
     */
    public static void main(String[] args) {
        final String text = "Base64 finally in Java 8!";

        String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        System.out.println(decoded);

        // 也支持URL和MINE的编码解码：
        // Base64.getUrlEncoder() / Base64.getUrlDecoder()
        // Base64.getMimeEncoder() / Base64.getMimeDecoder()
    }
}
