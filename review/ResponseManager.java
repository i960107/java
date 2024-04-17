package review;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResponseManager {
    private static final String OK = "200 OK";
    private static final String TODAY_REQUEST_URI = "/today";

    public void writeResponse(Socket client, RequestDto request) {
        try (PrintStream out = new PrintStream(client.getOutputStream())) {
            System.out.printf("%s %s %s \n", request.getUri(), request.getHttpVersion(), request.getRequestMethod());

            out.println(request.getHttpVersion() + " " + OK);
            out.println();
            if (request.getUri().equals(TODAY_REQUEST_URI)) {
                out.println(LocalDate.now());
            } else {
                out.println("working" + Thread.currentThread().getName());
            }
            out.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
