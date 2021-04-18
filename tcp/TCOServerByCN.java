//package tcp;
//
//import com.sun.org.apache.xpath.internal.operations.String;
//import sun.dc.pr.PRError;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: HuYu
// * Date: 2021-04-15
// * Time: 20:43
// */
//public class TCOServerByCN {
//    private  static final  int port =9004;
//
//
//    public TCOServerByCN() throws IOException {
//        ServerSocket serverSocket = new ServerSocket(port);
//        System.out.println("服务器已启动！");
//        // 2.等待客户端连接
//        Socket clientSocket = serverSocket.accept();
//        // 当执行到这一步，表示已经有客户端连接
//        System.out.println(String.format("已有客户端连接了，IP：%s，端口号：%d",
//                clientSocket.getInetAddress().getHostAddress(),
//                clientSocket.getPort()));
//        try (
//                BufferedWriter writer = new BufferedWriter(
//                        new OutputStreamWriter(clientSocket.getOutputStream()));
//                BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(clientSocket.getInputStream()))
//        ) {
//            while (true) {
//                //4.将英文翻译成中文；
//                java.lang.String en = reader.readLine();
//               if()
//                String cn = processData(en);
//                writer.write(cn + "\n");
//                writer.flush();
//            }
//        }
//    }
//private static String
//
//}
