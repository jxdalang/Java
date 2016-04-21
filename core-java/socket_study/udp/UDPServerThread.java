/**
* @package udp
* @author ZS@ZJU
* @version V1.0
*/
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
* @className UDPServerThread
* @description UDP服务器线程处理类
* @author ZS@ZJU
* @date Apr 20, 2016 11:32:06 PM
*/

public class UDPServerThread extends Thread {

    // 和本线程相关的Packet
    private DatagramPacket packet = null;

    public UDPServerThread(DatagramPacket packet) {
        this.packet = packet;
    }

    @Override
    public void run() {
        // 读取客户端发来的数据报
        byte[] data = packet.getData();
        String info = new String(data, 0, packet.getLength());
        System.out.println("我是服务器，客户端说：" + info);
        System.out.println("------------------------------------------");

        /*
         * 向客户端响应数据
         */
        // 创建一个Socket
        try (DatagramSocket socket = new DatagramSocket()) {
            // 创建数据报，包含响应的数据信息
            byte[] replyMessage = ("欢迎您--" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + "!")
                    .getBytes();
            DatagramPacket replyPacket = new DatagramPacket(replyMessage, replyMessage.length, packet.getAddress(),
                    packet.getPort());
            // 响应客户端
            socket.send(replyPacket);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
