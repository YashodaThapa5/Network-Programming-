import java.net.*;
public class URLExample {
    public static void main(String[] args) {
        try {
            String urlString = "https://example.com:8080/path/to/resource?query=value#section";
            URL url = new URL(urlString);
            System.out.println("Protocol: " + url.getProtocol()); //https
            System.out.println("Host: " + url.getHost()); //example.com
            System.out.println("Port: " + url.getPort()); //8080
            System.out.println("Path: " + url.getPath()); //path/to/resource
            System.out.println("Query: " + url.getQuery()); //query=value
            System.out.println("Ref: " + url.getRef()); //section
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
    }
}