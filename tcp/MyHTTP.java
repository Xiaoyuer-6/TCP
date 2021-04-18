package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-04-15
 * Time: 21:30
 */
public class MyHTTP {
    private static int port = 9004;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动！");
        Socket socket = serverSocket.accept();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()))
        ) {
            // 4.得到客户端信息
            // 得到首行信息
            String firstLine = reader.readLine();
            String [] firstLineArr = firstLine.split(" ");
            // 1、方法类型
            String method = firstLineArr[0];
            // 2、uri
            String uri = firstLineArr[1];
            //3、版本号
            String httpVersion = firstLineArr[2];
            System.out.println(String.format("首行信息 -> 方法类型：%s,URI：%s,HTTP版本号：%s", method, uri, httpVersion));


            String content ="";
            if(uri.contains("404")){
                content = "<h1>没有找到此页面</h1>";
            }else if(uri.contains("200")){
                content = "<h1>你好，世界！</h1>";
            }
            // 6.内容输出
            // 输出首行信息
            writer.write(String.format("%s 200 ok", httpVersion) + "\n");
            // 输出 head
            writer.write("Content-Type: text/html;charset=utf-8\n");
            writer.write("Content-Length: " + content.getBytes().length + "\n");
            // 输出空行
            writer.write("\n");
            writer.write(content);
            writer.flush();
        }
    }
}
