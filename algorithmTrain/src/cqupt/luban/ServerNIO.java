package cqupt.luban;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-02 9:43
 */
public class ServerNIO {

    static List<SocketChannel> list = new ArrayList<>();
    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);// ByteBuffer不能new  NIO特有的   可以申请堆外内存

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            // NIO可以将这个服务器socket设置成非阻塞
            serverSocketChannel.configureBlocking(false);

            while (true) {// 不断下面的if还是else执行完都会立马回来while-true
                // 现在是阻塞状态，一会设置成非阻塞
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    Thread.sleep(1500);
                    System.out.println("no  connection-----------------");
                    // 遍历已有的socket  看是否有发数据的
                    for(SocketChannel socketChannel1 : list) {
                        int read = socketChannel1.read(byteBuffer);
                        if (read > 0) {
                            byteBuffer.flip();
                            // 将byteBuffer内容输出  Charset NIO特有的
                            System.out.println(Charset.forName("utf-8").decode(byteBuffer));
                        }
                    }

                }else {// 有人来连接的话
                    System.out.println("have a  connection --------");
                    socketChannel.configureBlocking(false);// 让负责通信的socket为非阻塞
                    // 先把加进来的放进list
                    list.add(socketChannel);
                    // 遍历已有的socket  看是否有发数据的
                    for (int i = 0; i < list.size(); i++) {
                        int i1 = list.get(i).read(byteBuffer);
                        if (i1 > 0) {
                            byteBuffer.flip();
                            System.out.println(Charset.forName("utf-8").decode(byteBuffer));
                        }
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
