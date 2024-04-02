package chapter28;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ScatteringByteChannel;
import java.util.TreeMap;

public class SocketServerSample {
    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
//        sample.startServer();
        sample.startReplyServer();
    }

    private void startReplyServer() {
        System.out.println("server: waiting for request.");
        try (ServerSocket server = new ServerSocket(9999);
             Socket client = server.accept();
        ) {
            System.out.println("server:accepted.");

            BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());

            out.write("OK".getBytes());
            System.out.println("----------------");
            out.close(); //BufferedOutputStream은 close()시 flush()호출함.
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void startServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while (true) {
                System.out.println("server: waiting for request.");
                client = server.accept();
                System.out.println("server: accepted");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(stream)
                );
                String data = null;
                StringBuilder receivedData = new StringBuilder();
                while ((data = in.readLine()) != null) {
                    receivedData.append(data);
                }
                System.out.println("data received:" + receivedData);
                in.close();
                stream.close();
                client.close();
                if (receivedData != null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("---------------------------");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
