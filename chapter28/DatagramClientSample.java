package chapter28;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class DatagramClientSample {
    public static void main(String[] args) {
        DatagramClientSample sample = new DatagramClientSample();
        sample.sendDatagramSample();
    }

    private void sendDatagramSample() {
        for (int i = 0; i < 3; i++) {
            sendDatagramData("I liked UDP at " + new Date());
        }
        sendDatagramData("EXIT");
    }

    private void sendDatagramData(String data) {
        try (DatagramSocket client = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("127.0.0.1");
            byte[] buffer = data.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9999);
            client.send(packet);
            System.out.println("client: sent data");
            client.close();
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
