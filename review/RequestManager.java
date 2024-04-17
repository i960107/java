package review;

import java.io.*;
import java.net.Socket;

public class RequestManager {
    public RequestDto readRequest(Socket client) {
        //BufferedReader가 닫히지 않아 resource leak이 발생할 위험이 있지만 inputStream,socket까지 닫히는걸 방지하기 위해 그대로 둠.
        RequestDto dto = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String[] firstLineToken = in.readLine().split(" ");
            dto = new RequestDto(firstLineToken[0], firstLineToken[2], firstLineToken[1]);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return dto;
    }
}
