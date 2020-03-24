package cqupt.luban.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Liyi
 * @create 2020-03-01 17:38
 */
public class ServerBIO {


    static byte[] bytes = new byte[1024];

    public static void main(String[] args) {
        try {
            // 第一个socket对象 用来监听的
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));// socket绑定服务器
            System.out.println("等待连接");
            while (true) {
                // 阻塞的方法
                // 第二个socket对象 用来与客户端通信的
                Socket socket = serverSocket.accept();
                System.out.println("已连接上");
                System.out.println("等待数据");
                // 阻塞的方法  read中是读到的字节数
                int read = socket.getInputStream().read(bytes);
                String content = new String(bytes);
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
