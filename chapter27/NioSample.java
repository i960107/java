package chapter27;

import static java.io.File.separator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioSample {
    public static void main(String[] args) {
        NioSample sample = new NioSample();
        sample.basicWriteAndRead();
    }

    private void basicWriteAndRead() {
        String fileName = separator + "chapter27" + separator + "nio.txt";
        try {
            writeFile(fileName, "My First NIO Sample");
            readFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String fileName, String data) throws IOException {
        FileChannel channel = new FileOutputStream(fileName).getChannel();
        ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
        channel.write(buffer);
        channel.close();
    }

    private void readFile(String fileName) throws IOException {
        FileChannel channel = new FileInputStream(fileName).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }
        channel.close();
    }

}
