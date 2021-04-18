package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-04-15
 * Time: 20:00
 */
public class TCPClient {
    private static final String ip ="127.0.0.1";
    private static final int  port =9002;
    public static void main(String[] args) throws IOException {
        //1.创建顺便链接
        Socket socket = new Socket(ip,port);
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);
        ){
            while (true){
                System.out.println("->");
                String msg = scanner.nextLine();
                writer.write(msg+"\n");
                writer.flush();
                String  serMsg = reader.readLine();
                if(serMsg != null && !serMsg.equals("")){
                    System.out.println("服务器端返回: " +serMsg);
                }
            }
        }
    }
}
