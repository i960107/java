package review;

import java.io.IOException;
import java.net.Socket;

public class RequestHandler extends Thread {
    private final Socket client;
    private final RequestManager requestManager;
    private final ResponseManager responseManager;

    public RequestHandler(Socket client) {
        this.client = client;
        this.requestManager = new RequestManager();
        this.responseManager = new ResponseManager();
    }

    @Override
    public void run() {
        RequestDto requestDto = requestManager.readRequest(client);
        responseManager.writeResponse(client, requestDto);
    }
}
