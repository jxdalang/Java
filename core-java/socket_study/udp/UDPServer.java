package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 服务器端，实现基于UDP的用户登陆
 */
public class UDPServer {
    public static void main(String[] args) {
        /*
         * 接收客户端发送的数据
         */
        // 1.创建服务器端DatagramSocket，指定端口
        try (DatagramSocket socket = new DatagramSocket(8800)) {
            // 记录客户端的数量
            int count = 0;
            System.out.println("****服务器端已经启动，等待客户端发送数据");
            // 2.循环接收客户端发送的数据
            while (true) {
                // 3.创建数据报，用于接收客户端发送的数据
                byte[] data = new byte[1024];// 创建字节数组，指定接收的数据包的大小
                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);// 此方法在接收到数据报之前会一直阻塞
                // 4.创建一个新的线程用于回复客户端
                UDPServerThread serverThread = new UDPServerThread(packet);
                serverThread.setPriority(6);
                // 启动线程
                serverThread.start();

                count++; // 统计客户端的数量
                System.out.println("客户端的数量：" + count);
                System.out.println("刚收到数据的客户端IP:PORT " + packet.getAddress().getHostAddress() + ":" + packet.getPort());
            }
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
