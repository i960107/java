package review;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
    private static final int PORT = 9000;

    public void run() {
        //RequestHandler : Servlet Container 역할. 요청마다 쓰레드 생성 후 서블릿 호출
        //RequestHandler : Servlet. Spring이라면 DispatcherServlet
        //RequestManager: RequestMappingHandlerMapping -> uri에 매핑된 컨트롤러를 찾음. request parsing(실제로는 서블릿 역할)
        //ResponseManager: HttpMessageConverter. java 객체 내용을 message body에 씀.
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket client = server.accept();
                // 요청마다 RequestHandler 쓰레드 실행. 각 쓰레드는 각각의 RequestManager, ResponeManager를가짐
                RequestHandler requestHandler = new RequestHandler(client);
                requestHandler.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SimpleWebServer server = new SimpleWebServer();
        server.run();
    }
}
