package review;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleWebServerInitial {
    private static final int BUFFER_SIZE = 2048;

    public static void main(String[] args) {
        SimpleWebServerInitial sample = new SimpleWebServerInitial();
        int port = 9000;
        sample.start(port);
    }


    private void start(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            // 연결 유지. TCP 요청마다 연결
            // 서버 중지하지 않으면 계속 요청 받을 수 있는 상태 유지.
            while (true) {
                Socket client = server.accept();
                processRequest(client);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(Socket client) throws IOException {
        byte[] receivedBytes = new byte[BUFFER_SIZE];
        try (InputStream in = new BufferedInputStream(client.getInputStream());
             PrintStream response = new PrintStream(client.getOutputStream());
        ) {
            in.read(receivedBytes);
            String requestData = new String(receivedBytes).trim();
            System.out.println("received data = \n" + requestData);
            response.println("HTTP/1.1 200 OK");
            response.println("Content-type: text/string");
            response.println();
            response.print("It is working");
            response.flush();
        }
    }

}
