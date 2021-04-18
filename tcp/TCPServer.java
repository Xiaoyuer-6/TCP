package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-04-15
 * Time: 19:30
 */
public class TCPServer {
    private static final int port = 9002;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动！");
        // 2.等待客户端连接
        Socket clientSocket = serverSocket.accept();
        // 当执行到这一步，表示已经有客户端连接
        System.out.println(String.format("已有客户端连接了，IP：%s，端口号：%d",
                clientSocket.getInetAddress().getHostAddress(),
                clientSocket.getPort()));

        // jdk 7 try-resource
        try (
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))
        ) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                // 3.收、发消息
                // 接收客户端的消息
                String msg = reader.readLine();
                System.out.println("接收到客户端消息：" + msg);

                // 给客户端一个反馈消息
                String serMsg = "我收到了";
                writer.write(serMsg + "\n"); // \n 不能省略，数据流
                // 发送缓冲区刷新操作【执行此步骤意味着里面将缓冲区的消息发送出去】
                writer.flush();
            }
        }
    }
}