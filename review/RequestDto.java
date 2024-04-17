package review;

public class RequestDto {
    private final String requestMethod;
    private final String httpVersion;
    private final String uri;

    public RequestDto(String requestMethod, String httpVersion, String uri) {
        this.requestMethod = requestMethod;
        this.httpVersion = httpVersion;
        this.uri = uri;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getUri() {
        return uri;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}
