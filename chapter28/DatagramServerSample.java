package chapter28;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerSample {
    public static void main(String[] args) {
        DatagramServerSample sample = new DatagramServerSample();
        sample.startServer();
    }

    private void startServer() {
        try (DatagramSocket server = new DatagramSocket(9999);) {
            int bufferLength = 256;
            byte[] buffer = new byte[bufferLength];
            DatagramPacket packet = new DatagramPacket(buffer, bufferLength);
            while (true) {
                System.out.println("server: waiting for request");
                server.receive(packet);
                int dataLength = packet.getLength();
                System.out.println("server: received. data length= " + dataLength);
                String data = new String(packet.getData(), 0, dataLength);
                System.out.println("received data : " + data);
                if (data.equals("EXIT")) {
                    System.out.println("server: closed");
                    break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
