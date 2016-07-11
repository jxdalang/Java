package inetaddress_and_url;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress类
 */
public class TestInetAddress {

    public static void main(String[] args) throws UnknownHostException {
        // 获取本机的InetAddress实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算名：" + address.getHostName());
        System.out.println("IP地址：" + address.getHostAddress());
        System.out.println(address);// 直接输出InetAddress对象

        // 根据机器名获取InetAddress实例
        // InetAddress address2=InetAddress.getByName("laurenyang");
        InetAddress address2 = InetAddress.getByName("1.1.1.10");
        System.out.println("计算名：" + address2.getHostName());
        System.out.println("IP地址：" + address2.getHostAddress());
    }

}
