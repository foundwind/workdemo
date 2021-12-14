package shares;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2021/12/11
 */
public class EasyClient {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        // socket输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // socket输出流
        PrintWriter os = new PrintWriter(socket.getOutputStream());
        // 系统输入
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

    }
}
