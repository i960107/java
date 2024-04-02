package chapter28;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class SocketClientSample {
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
//        sample.sendSocketSample();
        sample.receiveSocketData();
    }

    private void receiveSocketData() {
        System.out.println("client:connecting");
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            System.out.println("client:connect status = " + socket.isConnected());
            Thread.sleep(1000);
            Scanner in = new Scanner(socket.getInputStream());
            while (in.hasNextLine()) {
                System.out.println("client: received data: " + in.nextLine());
            }
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String data = null;
//            while ((data = in.readLine()) != null) {
//                System.out.println("client: received data: " + data);
//            }
            in.close(); //BufferedReader 자동으로 닫힘. 체인으로 연결된 스트림을 닫음.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendSocketSample() {
        for (int loop = 0; loop < 3; loop++) {
            sendSocketData("I liked java at " + new Date());
        }
        sendSocketData("EXIT");
    }

    private void sendSocketData(String data) {
        Socket socket = null;
        try {
            System.out.println("client: connecting");
            socket = new Socket("localhost", 9999);
            System.out.println("client: connect status =" + socket.isConnected());
            Thread.sleep(1000);
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("client: sent data");
            out.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
