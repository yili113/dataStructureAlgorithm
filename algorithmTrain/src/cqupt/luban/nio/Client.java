package cqupt.luban.nio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Liyi
 * @create 2020-03-01 20:10
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            socket.getOutputStream().write("你好啊".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
